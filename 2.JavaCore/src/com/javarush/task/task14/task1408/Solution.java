package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();

//        System.out.println(hen.gerDescription());
    }

    // Описание курицы UkrainianHen должно соответствовать формату "getDescription()
    // родительского класса + Моя страна - Ukraine. Я несу N яиц в месяц.",
    // где N - число яиц в месяц(возвращаемое методом getCountOfEggsPerMonth. Например:
    // Я - курица. Моя страна - Ukraine. Я несу 5 яиц в месяц.

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            String[] arrStr = {Country.BELARUS, Country.MOLDOVA, Country.RUSSIA, Country.UKRAINE};
            Map<String, Hen> map = new HashMap<String, Hen>();
            map.put(arrStr[0], new BelarusianHen());
            map.put(arrStr[1], new MoldovanHen());
            map.put(arrStr[2], new RussianHen());
            map.put(arrStr[3], new UkrainianHen());
            return map.get(country);
//            return new BelarusianHen();
        }
    }


}
