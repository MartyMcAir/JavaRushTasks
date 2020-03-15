package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

// Observable - Deprecated
public class Tablet extends Observable {
    private static final Logger LOGGER = Logger.getLogger(Tablet.class.getName());
    ///
    private final int number; //  номер планшета, чтобы можно было однозначно установить, откуда поступил заказ.
    // ри возникновении исключений, наше приложение умрет. Чтобы узнать причину - добавим logger
    public static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }


    public Order createOrder() { // будет создавать заказ из тех блюд, которые выберет пользователь.
        // Также в методе createOrder класса Tablet должен быть создан новый заказ.
        Order order = null;
        try {
            // создает заказ заполняет список через ConsoleHelper для текущего планшета
            order = new Order(this);
            if (!order.isEmpty()) { // "Если в заказе отсутствуют блюда, он не должен быть отправлен повару

                // Добавьте вызов метода processVideos() в нужное место.
                // Не забудь что время приготовления заказа считается в минутах, а время показа рекламы в секундах!
                // как связать c Advertisement ?
//                Advertisement advertisement = new Advertisement(order.getTotalCookingTime() * 60);
//                AdvertisementManager advertisementManager = new AdvertisementManager();
//                advertisementManager.processVideos();
                try {
                    // перехватить в оптимальном месте (подумать, где это место) и с
                    // уровнем Level.INFO логировать фразу "No video is available for the order " + order

                    ////////////////////////////////////////////////////////////////
//                    new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
                    new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
                    ////////////////////////////////////////////////////////////////

                } catch (NoVideoAvailableException e) {
                    LOGGER.log(Level.INFO, "No video is available for the order " + order);
//                    Logger.getLogger(this.getClass().getName(), "No video is available for the order " + order);
                }
                setChanged(); // В методе createOrder класса Tablet должен быть вызван метод setChanged.
                notifyObservers(order); // вызван метод notifyObservers с текущим заказом в качестве параметра.
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        return order;

    }

    /////////////
    @Override
    public String toString() {
        // Пример: Your order: [Juice, Fish] of Tablet{number=5}
//        return "Your order: ";
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
