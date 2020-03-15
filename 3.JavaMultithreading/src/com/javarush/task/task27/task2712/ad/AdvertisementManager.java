package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// у каждого планшета будет свой объект менеджера, который будет подбирать оптимальный набор роликов
// и их последовательность для каждого заказа.
// Он также будет взаимодействовать с плеером и отображать ролики.
// при отправе вале Тайм Аут
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds; // время приготовления блюд в секундах, а условиях _ фраза про минуты путает
    /////////// общие данные для списка и список _ для рекурсии
    private List<Advertisement> advList; // список, что лучше предыдущего
    private long bestPrice; // цена всех роликов лучшего списка
    ///////////

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    // Очевидно, что этот метод должен вызываться во время создания заказа, а точнее - в параллельном режиме.
    // Заказ готовится в то время, как видео смотрится.
    public void processVideos() throws NoVideoAvailableException {
        // Подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду.
        if (storage.list().isEmpty()) { // Если нет рекламных видео, которые можно показать посетителю, то бросить
            throw new NoVideoAvailableException();
        }

        // 2.2. РЕКУРСИВНО Подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду.

        makeBestVideos(storage.list());
        Comparator<Advertisement> comparator = (o1, o2) -> { // в порядке уменьшения стоимости показа
            if (o1.getAmountPerOneDisplaying() > o2.getAmountPerOneDisplaying()) {
                return -1;
            } else if (o1.getAmountPerOneDisplaying() < o2.getAmountPerOneDisplaying()) {
                return 1;
            } else {
                return 0;
            }
        };
        // по увеличению стоимости показа одной секунды рекламного ролика в тысячных частях копейки
        Comparator<Advertisement> comparator2 = (o1, o2) -> {
            // делимстоимость показа 1рекламы на её длительность т.е. на сек.
            long amountO1 = o1.getAmountPerOneDisplaying() / o1.getDuration();
            long amountO2 = o2.getAmountPerOneDisplaying() / o2.getDuration();
            if (amountO1 > amountO2) {
                return -1;
            } else if (amountO1 < amountO2) {
                return 1;
            } else {
                return 0;
            }
        };
        Collections.sort(advList, comparator.thenComparing(comparator2));

        for (int i = 0; i < advList.size(); i++) {
            // вызываем на каждом видеоролике и уменьш _ кол-во достпуных показов
            System.out.println(advList.get(i));
            advList.get(i).revalidate();
        }

//        System.out.println(advList);
    }

    public void makeBestVideos(List<Advertisement> list) {
        if (!list.isEmpty()) {
            checkListV2(list);
        }
        for (int i = 0; i < list.size(); i++) {
            List<Advertisement> newList = new ArrayList<>(list);
            newList.remove(i);
            makeBestVideos(newList);
        }
    }

    /////////////////////////////////
    public int sumAllDurationsSeconds(List<Advertisement> list) {
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i).getDuration();
        }
        return res;
    }

    public long sumAllPricesCoins(List<Advertisement> list) {
        long res = 0;
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i).getAmountPerOneDisplaying();
        }
        return res;
    }

    public void checkListV2(List<Advertisement> list) {
        int durationList = sumAllDurationsSeconds(list);
        long coinsList = sumAllPricesCoins(list);

        if (advList == null) {
            if (durationList <= timeSeconds) {
                advList = list;
                bestPrice = coinsList;
            }
        } else { // т.е. уложились в время и при этом, общ цена всех роликов стала выше, то
            int durationAdvList = sumAllDurationsSeconds(advList);

            if (durationList <= timeSeconds && coinsList >= bestPrice) {
                if (coinsList > bestPrice) { // мани в приоритете
                    advList = list;
                    bestPrice = sumAllPricesCoins(list);
                }
                // есл сущ неск вариант набора видео-роликов с одинаковой суммой денег, полученной от показов
                if (coinsList == bestPrice) {
                    // выбрать тот вариант, у которого суммарное время максимальное
                    if (durationList > durationAdvList) {
                        advList = list;
                        bestPrice = coinsList;
                        // если суммар время у этих вариант одинаков, то выбрать вар с миним кол-во роликов;
                    } else if (durationList == durationAdvList) {
                        if (list.size() < advList.size()) {
                            advList = list;
                            bestPrice = coinsList;
                        }
                    }
                }
            }
        }
    }

    //////////////////////////////////////////////////
    public void checkList(List<Advertisement> list) {
        int durationList = sumAllDurationsSeconds(list);
        if (advList == null) {
            if (durationList <= timeSeconds) {
                advList = list;
                bestPrice = sumAllPricesCoins(list);
            }
        } else { // т.е. уложились в время и при этом, общ цена всех роликов стала выше, то
            if (durationList <= timeSeconds && sumAllPricesCoins(list) > bestPrice) {
                advList = list;
                bestPrice = sumAllPricesCoins(list);
            }
        }
    }
}
