package com.javarush.task.task21.task2107;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* 
Глубокое клонирование карты
*/
public class SolExp implements Cloneable {

    public static void main(String[] args) {
        SolExp solution = new SolExp();
        solution.users.add(new User(172, "Hubert"));
        solution.users.add(new User(41, "Zapp"));
        SolExp clone = null;

        System.out.println(users + ", size: " + users.size());
    }

    protected static Set<User> users = new HashSet<>();

    public static class User implements Cloneable {
        String name;
        int age;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int hashCode() {
//            int res = (name == null) ? 0 : name.hashCode();
//            return 31 * (res += age);
            return 3;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj.getClass() != this.getClass() || !(obj instanceof User)) return false;
            if (obj == this) return true;

            User obj2 = (User) obj;
            if ((obj2.name == null) ? this.name != null : !obj2.name.equals(this.name)) return false;
            if (obj2.age != this.age) return false;
            return true;
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            User newUser = new User(age, name);
            return newUser;
        }

        @Override
        public String toString() {
            return this.name + " " + this.age;

        }
    }

}
