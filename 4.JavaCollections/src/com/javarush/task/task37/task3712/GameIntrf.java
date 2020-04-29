package com.javarush.task.task37.task3712;

public interface GameIntrf {
    // так тож работает, но вале нужен абстрактный класс parent
    void prepareForTheGame();

    void playGame();

    void congratulateWinner();

    default void run() {
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }
}
