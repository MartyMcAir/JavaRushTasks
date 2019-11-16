package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
*/
public class Tmp {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
//        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
//        return (d && a && b && !c); // верно для false
        return (!c && d && a && b); // верно для false
    }

    public static void main(String[] args) {
        // true если
        //          true true true true
        //          false false true true
        //          false false true false

        // false если
        //          false false false false
        //          true false false false
        //          true true false false
        //          true true false true
//        System.out.println(calculate(a, b, c, d));


//        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);

        boolean a = true;
        boolean b = true;
        boolean c = true; // ???
        boolean d = false;

        //  true если все true а последн false, иначе false
        // true состояние возможно только в одной комбинации
        System.out.println((a && b && c && !d));   // false если 1 из них false, кроме последнего
        // если первый true или перв false но при этом след true то вернет true иначе false

        System.out.println((!a && c));   // true если первый false а второй true, если первый true вернет false

        System.out.println((!b && c));   // тоже самое
        System.out.println((c && d));   // true если оба true, если первый false то вернет false
    }
}
