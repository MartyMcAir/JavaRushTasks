package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage { // хранилище рекламных роликов.
    private static AdvertisementStorage advertisementStorage = null;
    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();
        Advertisement ad1 = new Advertisement(someContent, "Immortal",
                5000, 10, 3 * 60); // 3 min _ 2.7price per sec
        Advertisement ad2 = new Advertisement(someContent, "Future is bee come",
                100, 10, 15 * 60); // 15 min
        Advertisement ad3 = new Advertisement(someContent, "We make future",
                400, 10, 10 * 60); // 10 min _ 0,066
        Advertisement ad4 = new Advertisement(someContent, "Iron 1",
                300, 10, 2 * 60); // 2 min _ 0,25
        Advertisement ad5 = new Advertisement(someContent, "Iron 2",
                450, 10, 4 * 60); // 4 min _ 0,1875
        Advertisement ad6 = new Advertisement(someContent, "Iron 3",
                600, 10, 6 * 60); // 6 min _ 0,1666
        add(ad1);
        add(ad2);
        add(ad3);
        add(ad4);
        add(ad5);
        add(ad6);
    }

    public static AdvertisementStorage getInstance() {
        if (advertisementStorage == null) {
            advertisementStorage = new AdvertisementStorage();
        }
        return advertisementStorage;
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
