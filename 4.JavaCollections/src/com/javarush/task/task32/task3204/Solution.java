package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.Callable;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPasswordIs();
        System.out.println(password.toString());
    }

    private static ByteArrayOutputStream getPasswordIs() {
        Random rnd = new Random();
        int number = 48 + rnd.nextInt(57 - 48) + 1;
        int UpperCase = 65 + rnd.nextInt(90 - 65) + 1;

        ByteArrayOutputStream btOut = new ByteArrayOutputStream();
        btOut.write(number);
        btOut.write(UpperCase);
        return btOut;
    }


//    Не делал никаких массивов и проверок) решил пойти просто в лоб с 1 первой попытки получилось)
//            8 рандомных чисел по таблице ASCII.
//            пример строчки
//    Random rnd = new Random();
//    int number = 48 + rnd.nextInt(57 - 48) + 1;
//    int UpperCase = 65 + rnd.nextInt(90 - 65) + 1;
//
//    затем писал все 8 строчке в ByteArrayOutputStream и return; Всем удачи!!! :-)

    // принял!)
    public static ByteArrayOutputStream getPassword() throws IOException {
        char[] arrAll = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z',
                '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

        char[] arrUp = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] arrLow = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z'};
        char[] arrNumChar = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

        // 8 рандомных чисел по таблице ASCII.
        // int number = 48 + rnd.nextInt(57 - 48) + 1;
        // int UpperCase = 65 + rnd.nextInt(90 - 65) + 1;

        ArrayList<Character> list = new ArrayList<>();
        Collections.addAll(list, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z',
                '1', '2', '3', '4', '5', '6', '7', '8', '9', '0');


        Random rnd = new Random();
        Date time = Calendar.getInstance().getTime();

        Random rnd2 = new Random();
        ByteArrayOutputStream btOut = new ByteArrayOutputStream();

        String rndSymbolUp, rndSymbolDwn, randNumb, res = "";
        boolean flag1 = false, flag2 = false, flag3 = false;

        StringBuilder sb = new StringBuilder();
        int k = 0;
        while (true) {
            int random = (int) (Math.random() * 3);

            // Upper либо LowerCase
            rnd.setSeed(time.getTime());

            rndSymbolUp = String.valueOf(arrUp[rnd.nextInt(arrUp.length)]);
            rnd.setSeed(time.getTime());
            rndSymbolDwn = String.valueOf(arrLow[rnd.nextInt(arrLow.length)]);
            randNumb = String.valueOf(arrNumChar[rnd.nextInt(arrNumChar.length)]);
            rnd.setSeed(time.getTime());

            if (random == 0 & !flag1) {
                sb.append(rndSymbolDwn);
                flag1 = true;
                k++;
            }
            if (random == 1 & !flag2) {
                sb.append(rndSymbolUp);
                flag2 = true;
                k++;
            }
            if (random == 2 & !flag3) {
                sb.append(randNumb);
                flag3 = true;
                k++;
            }

            if (flag1 & flag2 & flag3) {
                Collections.shuffle(list);
                char c = list.get((int) (Math.random() * list.size()));
                k++;
                sb.append(c);
            }
            if (k == 8) {
                break;
            }

//            char c = arrAll[(int) (Math.random() * arrAll.length)];
//            sb.append(c);
//            if (sb.toString().length() == 16) ;
//            break;
        }
        res = sb.toString();
        btOut.write(res.getBytes());
        return btOut;
    }

    // Валя не принял
    public static ByteArrayOutputStream getPasswordMyV1() throws IOException {
        double random = Math.random() * 3;

        char[] arrUp = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] arrLow = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z'};
        char[] arrNumChar = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

        // 8 рандомных чисел по таблице ASCII.
        // int number = 48 + rnd.nextInt(57 - 48) + 1;
        // int UpperCase = 65 + rnd.nextInt(90 - 65) + 1;

        Random rnd = new Random();
        Random rnd2 = new Random();
        ByteArrayOutputStream btOut = new ByteArrayOutputStream();
        boolean flag = true;
        String rndSymbol, randNumb, res = "";
        for (int i = 0; i < 8; i++) {
            // Upper либо LowerCase
            rndSymbol = flag ? String.valueOf(arrUp[rnd.nextInt(arrUp.length)]) :
                    String.valueOf(arrLow[rnd.nextInt(arrLow.length)]);
            flag = !flag;
            randNumb = String.valueOf(arrNumChar[rnd.nextInt(arrNumChar.length)]);

            if (i < 2)
                res = String.valueOf(arrUp[rnd.nextInt(arrUp.length)]);
            if (i > 2 & i < 4)
                res = String.valueOf(arrNumChar[rnd.nextInt(arrNumChar.length)]);
            if (i > 4 & i < 6)
                res = String.valueOf(arrNumChar[rnd.nextInt(arrNumChar.length)]);
            else { // либо цифра либо буква
                res = rnd2.nextBoolean() ? rndSymbol : randNumb;
            }

            btOut.write(res.getBytes());
        }
        return btOut;
    }
}