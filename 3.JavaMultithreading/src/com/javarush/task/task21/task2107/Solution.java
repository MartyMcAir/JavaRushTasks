package com.javarush.task.task21.task2107;

import java.io.StringReader;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        // но лучше еслибы можно было users.clone() _ но он protected
//        ((LinkedHashMap<String, User>) usersNew).clone()
//        Solution.this.users.putAll(this.users); // более кратки вариант
        Solution newSol = new Solution();
        Map<String, User> usersNew = new LinkedHashMap();
        for (Map.Entry<String, User> pare : users.entrySet()) {
            usersNew.put(pare.getKey(), pare.getValue());
//            usersNew.put(pare.getKey(), pare.getValue().clone());
        }
        newSol.users = usersNew;
        return newSol;
    }

    public static class User implements Cloneable {
        int age;

        @Override
        public String toString() {
            return this.name + " " + this.age;

        }

        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int hashCode() {
            int res = (name == null) ? 0 : name.hashCode();
            return 31 * (res += age);
//            return 3;
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
    }

}
