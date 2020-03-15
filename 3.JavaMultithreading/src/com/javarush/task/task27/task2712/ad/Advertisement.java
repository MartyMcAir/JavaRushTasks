package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    // Рекламное объявление
    // Модификаторы доступа расставь самостоятельно.
    public Object content; // видео
    private String name; // имя название
    private long initialAmount; // стоимость рекламы в копейках _ (ЭТО ОБЩАЯ СТОИМОСТЬ_ а в условии это не указано)
    private int hits; // кол-во оплаченных показов
    public int duration; // продолжительность в сек
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        // Оно должно равняться стоимости одного показа рекламного объявления в копейках
        this.amountPerOneDisplaying = initialAmount / hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() throws UnsupportedOperationException {
        // 2.5.1. Бросать UnsupportedOperationException, если количество показов не положительное число.
        if (hits == 0) {
            throw new UnsupportedOperationException();
        }
        hits--; // 2.5.2. Уменьшать количество показов.
    }

    /////////////////

    public int getHits() {
        return hits;
    }

    public long getAmountPerOneSecond() {
        return amountPerOneDisplaying * 1000 / duration;
    }

    public long getAmountPerOneSecondDisplaying() {
        return amountPerOneDisplaying * 1000 / duration;
    }

    @Override
    public String toString() {
        return "[ " + name + " is displaying.., price: " + getAmountPerOneDisplaying()
                + ", price for one second: 0," + getAmountPerOneSecondDisplaying() + " ]";
    }

    public long getInitialAmount() {
        return initialAmount;
    }
}
