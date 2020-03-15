package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    // From Comments _ ничего не понял про дополнение нулями до 32 символов .. о чем это вообще?
    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(byteArrayOutputStream.toByteArray());
        //получаем MD5-хеш ( без лидирующих нулей )
        String s = new BigInteger(1, messageDigest.digest()).toString(16);
        //дополняем нулями до 32 символов, в случае необходимости
        while (s.length() < 32) {
            s = "0" + s;
        }
        return MessageDigest.isEqual(md5.getBytes(), s.getBytes());
    }

    public static boolean compareMD5_V1(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        messageDigest.update(md5.getBytes());
        byte[] digest = messageDigest.digest();
        System.out.println(Arrays.toString(digest));
        BigInteger bigInteger = new BigInteger(1, digest);

        System.out.println(bigInteger); // 177828691401756452807276314331237097708
        System.out.println(bigInteger.toString()); // 177828691401756452807276314331237097708
        System.out.println(bigInteger.toString(16)); // 85c88f6793483a6de5e416f6f278a0ec

        String hexString = String.format("%x", new BigInteger(1, digest)); // 85c88f6793483a6de5e416f6f278a0ec


        MessageDigest msd2 = MessageDigest.getInstance("MD5");
        msd2.update(byteArrayOutputStream.toByteArray());
        System.out.println(new BigInteger(1, msd2.digest())); // 120003415063101618126808279510440563435

        System.out.println(hexString);


        return false;
    }
}
