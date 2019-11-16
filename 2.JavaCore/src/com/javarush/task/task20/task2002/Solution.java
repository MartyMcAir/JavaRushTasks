package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File yourFile = File.createTempFile("your_file_name", null);
            File yourFile = new File(myPath()[0]);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User u1 = new User();
            u1.setMale(false);
            u1.setFirstName("aSuka");
            u1.setLastName("Lamperush");
            SimpleDateFormat sdf = new SimpleDateFormat();
            Calendar cal = Calendar.getInstance();
            cal.set(2005, 8, 13);
            u1.setCountry(User.Country.OTHER);
            u1.setBirthDate(cal.getTime());
            javaRush.users.add(u1);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            System.out.println("Oops, something is wrong with my file");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Oops, something is wrong with the save/load method");
            e.printStackTrace();
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter prW = new PrintWriter(outputStream);
            String isUsers = users.isEmpty() ? "N" : "Y";
            if (isUsers.equals("N")) {
                prW.println(isUsers);
            }
            if (isUsers.equals("Y") & users != null & users.size() > 0) {
                prW.println(isUsers);
                for (User item : this.users) {
                    prW.println(item.isMale()); // пол _  boolean
                    prW.println(item.getFirstName());   // name
                    prW.println(item.getLastName());   // фамилия
//                    prW.println(item.getBirthDate());   // день рождеия
                    // записываем как long, для удобства парсинга
                    prW.println(item.getBirthDate().getTime());   // день рождеия
//                    System.out.println(item.getCountry().getDisplayName()); // Other
                    prW.println(item.getCountry().getDisplayName());   // страна
                }
            }
            prW.flush();
            prW.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bfR = new BufferedReader(new InputStreamReader(inputStream));
            String isUsers = bfR.readLine();
            if (isUsers.equals("Y")) {
                SimpleDateFormat sdf = new SimpleDateFormat();
                while (bfR.ready()) {
                    boolean isMale = Boolean.parseBoolean(bfR.readLine());
                    String firstName = bfR.readLine();
                    String lastName = bfR.readLine();
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(new Date(Long.parseLong(bfR.readLine())));
                    Date birthDate = cal.getTime();
                    User.Country country = User.Country.valueOf(bfR.readLine().toUpperCase());
                    User uNew = new User();
                    uNew.setMale(isMale);
                    uNew.setFirstName(firstName);
                    uNew.setLastName(lastName);
                    uNew.setBirthDate(birthDate);
                    uNew.setCountry(country);
                    this.users.add(uNew);
                }
            }
            bfR.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
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
