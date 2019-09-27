package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import javax.swing.text.MaskFormatter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        IncomeDataAdapter inc = new IncomeDataAdapter(new IncomeImp());
        System.out.println(inc.getCompanyName());
        System.out.println(inc.getCountryName());
        System.out.println(inc.getName());
        System.out.println(inc.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() { // по коду получаем имя страны
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            // нули надо добавлять перед 501234567
            String num = String.format("%010d", data.getPhoneNumber());
            return String.format("+%d(%.3s)%s-%s-%s", data.getCountryPhoneCode(),
                    num, num.substring(3, 6), num.substring(6, 8), num.substring(8, 10)); // +38(050)123-45-67
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }

    public static class IncomeImp implements IncomeData {

        @Override
        public String getCountryCode() {
            return "UA";
        }

        @Override
        public String getCompany() {
            return "JavaRush Ltd.";
        }

        @Override
        public String getContactFirstName() {
            return "Ivan";
        }

        @Override
        public String getContactLastName() {
            return "Ivanov";
        }

        @Override
        public int getCountryPhoneCode() {
            return 38;
        }

        @Override
        public int getPhoneNumber() {
            return 501234567;
        }
    }
}