package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// NOtMy_V2
// From https://github.com/fighter-hd/JavaRushTasks/blob/master/3.JavaMultithreading/src/com/javarush/task/task27/task2712/ad/AdvertisementManager.java

// Валя жалуется на:
// Убедись, что отобранные для показа рекланые ролики отсортированы согласно условию.
// Если существует несколько вариантов набора видео-роликов с одинаковой суммой денег, полученной от показов,
// то должен быть выбран вариант с максимальным суммарным временем.

// Если существует несколько вариантов набора видео-роликов с одинаковой суммой денег и одинаковым
// суммарным временем, то должен быть выбран вариант с минимальным количеством роликов.

// В набор должны отбираться только ролики с положительным числом показов.
public class AdvertisementManager_NotMyV2_2 {
    private int timeSeconds;

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public AdvertisementManager_NotMyV2_2(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> advertisements1 = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits() > 0) { // отфильтровывваем на положительное числом показов
                advertisements1.add(advertisement);
            }

        }
        List<Advertisement> advertisements2 = new ArrayList<>();
        chooseAdvertisement(advertisements1, advertisements2, timeSeconds);

        int timeLeft = timeSeconds;
        for (Advertisement advertisement : advertisements2) {
            if (timeLeft < advertisement.getDuration()) {
                continue;
            }

            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", "
                    + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());

            timeLeft -= advertisement.getDuration();
            advertisement.revalidate();
        }

        if (timeLeft == timeSeconds) {
            throw new NoVideoAvailableException();
        }
    }

    // метод берет входной список begin _ и на выходе кидает присваивает результ в список end
    private void chooseAdvertisement(List<Advertisement> begin, List<Advertisement> end, int time) {
        if (begin.isEmpty()) { // если начальный закончился..
            return; // условия выхода из рекурсии
        }
        Advertisement chooseAdvertisement;
        //  max() - выполняет поиск максимального значения в списке и возвращает элемент.
        Advertisement advertisementAmount = Collections.max(begin,
                Comparator.comparing(Advertisement::getAmountPerOneDisplaying));
        // filter() - отфильтровываем-убираем, ролики равные по стоимости за 1 секунду _
        // - с максимально найденным в предыдущем стриме max()..
        List<Advertisement> advertisementsAmount = begin.stream().filter(advertisement -> advertisement
                .getAmountPerOneDisplaying() == advertisementAmount.getAmountPerOneDisplaying())
                .collect(Collectors.toList());

        if (advertisementsAmount.size() > 1) { // если после всех манипуляций список, все еще более 1 ролика
            // вычисляем роилк максимал длины
            Advertisement advertisementDuration = Collections.max(advertisementsAmount,
                    Comparator.comparing(Advertisement::getDuration));
            // filter() - отфильтровываем-убираем, ролики равные продолжительности
            // - с максимал найденным в предыдущ стриме
            List<Advertisement> advertisementsDuration = advertisementsAmount.stream()
                    .filter(advertisement -> advertisement
                            .getDuration() == advertisementDuration.getDuration())
                    .collect(Collectors.toList());

            if (advertisementsDuration.size() > 1) { // из полученного списка отбираем максим элемент
                chooseAdvertisement = Collections.max(advertisementsDuration,
                        Comparator.comparing(Advertisement::getHits));
            } else {
                chooseAdvertisement = advertisementDuration;
            }
        } else {
            chooseAdvertisement = advertisementAmount;
        }
        begin.remove(chooseAdvertisement);
        if (time >= chooseAdvertisement.getDuration()) {
            end.add(chooseAdvertisement);
            time -= chooseAdvertisement.getDuration();
        }
        chooseAdvertisement(begin, end, time);
    }
}
