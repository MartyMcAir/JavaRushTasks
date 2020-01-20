package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            //init wheels here
            if (loadWheelNamesFromDB().length < 0 | loadWheelNamesFromDB().length != 4) {
                throw new Exception(); // проверка на null
            }
            List<String> listChecked = new ArrayList<>();
            for (Wheel item : Wheel.values()) {
                listChecked.add(item.toString());
            }

            wheels = new ArrayList<>();
            for (String item : loadWheelNamesFromDB()) {
                if (listChecked.contains(item)) {
                    wheels.add(Wheel.valueOf(item));
                } else {
                    // В случае возврата неправильных данных о колесах, нужно кинуть исключение.
                    throw new Exception();
                }
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception {
        Car car = new Car();
        car.loadWheelNamesFromDB();
    }
}
