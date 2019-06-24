package com.javarush.task.task13.task1307;

/* 
Параметризованый интерфейс
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    // При реализации обобщенного интерфейса обычным классом, в скобках "<>" следует
    // указывать реальный, а не обобщенный  тип
    class StringObject implements SimpleObject<String>{ //допишите здесь ваш код
        @Override
        public SimpleObject<String> getInstance(){
            return null;
        }
    }
}