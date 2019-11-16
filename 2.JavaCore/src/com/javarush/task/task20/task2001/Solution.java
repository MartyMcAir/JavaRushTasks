package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.*;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //            File your_file_name1 = File.createTempFile(myPath()[0], "pontY");
            //            OutputStream outputStream = new FileOutputStream(your_file_name1);
            //            InputStream inputStream = new FileInputStream(your_file_name1);

            OutputStream outputStream = new FileOutputStream(myPath()[0]);
            InputStream inputStream = new FileInputStream(myPath()[0]);

//            OutputStream outputStream = new FileOutputStream("C:\\Users\\OOS 4\\Desktop\\abd.txt");
//            InputStream inputStream = new FileInputStream("C:\\Users\\OOS 4\\Desktop\\abd.txt");

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true; // если текущий объект равен o
            if (o == null || getClass() != o.getClass()) return false; // если класс текущего не равен классу o

            Human human = (Human) o;
            // если name != null т.е. true, то вернет результат выражения !name.equals(human)
            // иначе если name == null т.е. false, то венет результат выражения human != null

            // если name объектов НЕ equals или если human.name не равен null
            // короче вернет false если строки объектов не равны и они не null
            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            // сравнивается объект список assets текущего объекта с human списком
            // если assets != null т.е. true, то вернету результ выражения assets.equals(human.assets)
            // а иначе human.assets == null
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            String assetSiza = assets.isEmpty() ? "no" : "yes";
            writer.write(assetSiza);
            writer.write(System.lineSeparator());
            writer.write(name);
            writer.write(System.lineSeparator());

            if (assetSiza.equals("yes")) {
                for (Asset e : assets) {
                    writer.write(e.getName());
                    writer.write(System.lineSeparator());
                    writer.write((Double.toString(e.getPrice())));
                    writer.write(System.lineSeparator());
                }
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String assetSiza = reader.readLine();
            name = reader.readLine();
            Asset ass = null;
            while (reader.ready()) {
                if (assetSiza.equals("yes")) {
                    //for (int i=0;i<assets.size();i++) {
                    ass = new Asset(reader.readLine(), Double.parseDouble(reader.readLine()));
                    this.assets.add(ass);
                    //System.out.println(ass.getName() + " " + ass.getPrice());
                    //}
                }
            }
            reader.close();
        }
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir
                + "file1.txt.pont", dir
                + "file_2.txt", dir
                + "file3.txt"};
    }
}
