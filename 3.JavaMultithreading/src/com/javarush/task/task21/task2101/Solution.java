package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000


    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netA = new byte[ip.length];
        for (int i = 0; i < ip.length; i++) {
            netA[i] = (byte) (ip[i] & mask[i]);
        }

        return netA;
    }

    public static void print(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
//            System.out.print(String.format("%08d", Integer.valueOf("" + Integer.toBinaryString(bytes[i] & 0xFF))) + " ");

//            System.out.print(String.format("%8s", Integer.toBinaryString(bytes[i] < 0 ? bytes[i] + 256 : bytes[i])).
//                    replace(" ", "0") + " ");

//            System.out.print(String.format("%8s", Integer.toBinaryString(bytes[i] < 0 ? 256 + bytes[i] : bytes[i])).
//                    replace(' ', '0') + " ");
            System.out.print(Integer.toBinaryString((bytes[i] & 0xFF) + 256).substring(1) + " ");
        }
        System.out.println();
    }

//    public static void print(byte[] bytes) {
//        StringBuilder binA = new StringBuilder();
//        for (byte a : bytes) {
//            String bit = (Integer.toBinaryString(Byte.toUnsignedInt(a)));
//            if (bit.length() < 8) {
//                int count = 8 - bit.length();
//                for (int i = 0; i < count; i++) {
//                    binA.append("0");
//                }
//                binA.append(bit + " ");
//            } else binA.append(bit + " ");
//        }
//
//        System.out.println(binA.toString());
//    }
}
