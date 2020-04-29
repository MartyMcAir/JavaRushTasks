package com.javarush.task.task35.task3508;

import javax.swing.text.AttributeSet;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;

/* 
extends vs super
*/
public abstract class Solution_V2 {
    // писать - в super
    //читать - из extends
    //пару лекций назад есть примеры

    // java.lang.Object
    // java.lang.Throwable
    // java.lang.Exception
    // java.lang.RuntimeException
    // java.lang.NullPointerException
    public static void main(String[] args) {
//        Run_V1();
//        BoundedType();
//        tmp();

        System.out.println(getDoubleValue(new OptionInteger(123)));
        System.out.println(getDoubleValue(new OptionNumber<>(3.14)));

        OptionInteger n1 = new OptionInteger(123);
        setInteger(n1);
        OptionNumber<Number> n2 = new OptionNumber<>(123.33);
        setInteger(n2);

        System.out.println(n1.getValue());  // 123
        System.out.println(n2.getValue());   // 123.33

    }

    static void setInteger(OptionValue<? super Integer> opt) {
        opt.setValue(33);
    }


    static double getDoubleValue(OptionNumber<? extends Number> opt) {
        return opt.getValue().doubleValue();
    }

    private static class OptionValue<V> {
        private V value;

        public OptionValue(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static class OptionNumber<N extends Number> extends OptionValue<N> {
        public OptionNumber(N attr) {
            super(attr);
        }
    }

    public static class OptionInteger extends OptionNumber<Integer> {
        public OptionInteger(Integer value) {
            super(value);
        }
    }

    private static void tmp() {
        List<MiddleClazz2> listMid = new ArrayList<>(); // в find wrong argument for <SuperClazz2>
        listMid.add(new MiddleClazz2("name1"));
        listMid.add(new MiddleClazz2("name2"));
        listMid.add(new MiddleClazz2("name3"));
        find(listMid, new MiddleClazz2("name1"));
        find(listMid, new ChildClazz2("name3"));
        find(listMid, new SuperClazz2("name3")); // cannot be appealed for List<T> all

        /////////
        List<MiddleClazz2> listMid2 = new ArrayList<>();
        listMid2.add(new MiddleClazz2("mid 1"));
        listMid2.add(new MiddleClazz2("mid 2"));

        List<ChildClazz2> listChild2 = new ArrayList<>();
        listChild2.add(new ChildClazz2("child 1"));
        listChild2.add(new ChildClazz2("child 2"));

        List<SuperClazz2> listSup2 = new ArrayList<>();
        listSup2.add(new SuperClazz2("sup 1"));
        listSup2.add(new SuperClazz2("sup 2"));

        displayList(listMid2);
        displayList(listChild2);
        displayList(listSup2);


        copy2(listSup2, listMid2);
        copy2(listSup2, listChild2);
//        copy2(listMid2, listChild2); // compile err

        displayList2(new ArrayList<Number>());
        displayList2(new ArrayList<Integer>());
    }

    public static void displayList2(List<? extends Number> list) {
        for (Number n : list)
            System.out.println(n);
    }

    public static <T> void copy2(List<T> to, List<? extends T> from) {
//    public static <T extends SuperClazz2> void copy2(List<SuperClazz2> to, List<T> from) {
        to.add(from.get(0));
//        from.add(to.get(0));
    }

    //    public static <T> void displayList(List<SuperClazz2> list) { // сompile err for listMid2 and listChild2
//    public static <T> void displayList(List<T> list) { // всё ок
//        for (T t : list)
//    public static void displayList(List<?> list) { // всё ок
//        for (Object t : list) // но доступны методы только класс Object
    public static void displayList(List<? extends SuperClazz2> list) { // всё ок
        for (SuperClazz2 t : list) // но доступны методы только класс Object
            System.out.println(t);
    }

    //    public static void copy(List<? super MiddleClazz2> src, List<SuperClazz2> dest) { // err
    // указывает компилятору, что T extends SuperClazz2
//    public static <T extends SuperClazz2> void copy(List<T> src, List<SuperClazz2> dest) { // всё ок
//    public static void copy(List<SuperClazz2> src, List<SuperClazz2> dest) { // всё ок
    public static void copy(List<? extends SuperClazz2> src, List<? super SuperClazz2> dest) { // всё ок
        for (SuperClazz2 item : src) {
            dest.add(item);
        }
    }

    //    public static boolean find(List<SuperClazz2> all, SuperClazz2 sup) { // _ Compile Err
    public static boolean find(List<? extends SuperClazz2> all, SuperClazz2 sup) { // No Err
        // пример с дженерилизацией всего метода _ err for find(listMid, new SuperClazz2("name3"));
//    public static <T extends SuperClazz2> boolean find(List<T> all, T sup) { // No Err
        for (SuperClazz2 item : all) {
            if (item.getName().equals(sup.getName()))
                return true;
        }
        return false;
    }

    private static void BoundedType() {
        TestClass testClass = new TestClass();
        Container<SuperClazz> container1 = new Container<>("container1");
        Container<MiddleClazz> container2 = new Container<>("container2");
        Container<ChildClazz> container3 = new Container<>("container3");
//        Container<String> container4 = new Container<>("container4"); // is not within its bound; should extend
        System.out.println(container1);
        System.out.println(container2);
        System.out.println(container3);
        System.out.println(container1.getT());   // null
    }

    //    public static class Container2<T super SuperClazz> { // Unexpected token
    public static class Container2<T extends SuperClazz> {
        private T t;
        private String containerName;

        public Container2(String containerName) {
            this.containerName = containerName;
        }

        @Override
        public String toString() { // return "t=" + t.getClass() + '\''; // NullPointerException
            return containerName;
        }
    }

    public static class Container<T extends SuperClazz> {
        private T t;
        private String containerName;

        public Container(String containerName) {
            this.containerName = containerName;
        }

        public T getT() {
            return t;
        }

        @Override
        public String toString() { // return "t=" + t.getClass() + '\''; // NullPointerException
            return containerName;
        }
    }

    public static class SuperClazz2 {
        private String name;

        public SuperClazz2(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "SuperClazz{" + name + "}";
        }
    }

    public static class MiddleClazz2 extends SuperClazz2 {
        public MiddleClazz2(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "MiddleClazz{" + getName() + "}";
        }
    }

    public static class ChildClazz2 extends MiddleClazz2 {
        public ChildClazz2(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "ChildClazz{" + getName() + "}";
        }
    }

    public static class SuperClazz {
        @Override
        public String toString() {
            return "SuperClazz{}";
        }
    }

    public static class MiddleClazz extends SuperClazz {
        @Override
        public String toString() {
            return "MiddleClazz{}";
        }
    }

    public static class ChildClazz extends MiddleClazz {
        @Override
        public String toString() {
            return "ChildClazz{}";
        }
    }

    private static void Run_V1() {
        List<String> listStr = new ArrayList<>();
        listStr.add("one");
//        listStr.add(new Object()); // // cannot be appealed
//        listStr.add(2); // cannot be appealed

        List<MiddleClazz> listLevels = new ArrayList<>();
        listLevels.add(new ChildClazz());  // good
        listLevels.add(new MiddleClazz());
//        listLevels.add(new SuperClazz());  // cannot be appealed
        listLevels.forEach(v -> System.out.println(v));


        List<? extends RuntimeException> listExtends = new ArrayList<>();
//        listExtends.add(new RuntimeException());  // cannot be appealed ___ WTF!?
//        listExtends.add(new Exception());  // cannot be appealed
//        listExtends.add(new NullPointerException());  // cannot be appealed
//        listExtends.add(new Object());  // cannot be appealed

        List<? extends MiddleClazz> listWildsCardsExt = new ArrayList<>();
//        listWildsCardsExt.add(new MiddleClazz());  // cannot be appealed ___ WTF!?
//        listWildsCardsExt.add(new ChildClazz());  // cannot be appealed
//        listWildsCardsExt.add(new SuperClazz());  // cannot be appealed

        /////////////////////
        List<? super Exception> listSuper = new ArrayList<>(); // пропуск всех наследников класса Exception
        listSuper.add(new Exception());
        listSuper.add(new RuntimeException());
        listSuper.add(new NullPointerException());
//        listSuper.add(3);   // cannot be appealed
//        listSuper.add(new Object());   // cannot be appealed

        List<? super MiddleClazz> listWildsCards = new ArrayList<>();
        listWildsCards.add(new MiddleClazz());
        listWildsCards.add(new ChildClazz());
//        listWildsCards.add(new SuperClazz());   // cannot be appealed
//        listWildsCards.add(3);  // cannot be appealed
    }


    public static class TestClass {
        //  должен работать с одним и тем же типом;
        public <T> void one(List<T> destination, List<T> source) {
            System.out.println(destination.get(0).getClass());
            System.out.println(source.get(0).getClass());
        }

        // должен добавлять любых наследников типа T в список, умеющий хранить только тип T;
//        public <T> void two(List<? super T> destination, List<? extends T> source) {
//        public <T> void two(List<? super Object> destination, List<? extends T> source) {
        public <T> void two(List<? super Object> destination, List<? extends T> source) {
            destination.add(source);
//            source.add(destination);
        }

        // должен добавлять объекты типа T в любой список, параметризированный любым родительским классом;
        public <T> void three(List<? extends T> destination, List<? super T> source) {

        }

        // должен добавлять любых наследников типа T в  список, умеющий хранить только тип T;
        public <T> void four(List destination, List source) {

        }
    }

    //  должен работать с одним и тем же типом;
    public abstract <T> void one(List destination, List source);

    // должен добавлять любых наследников типа T в  список, умеющий хранить только тип T;
    public abstract <T> void two(List destination, List source);

    // должен добавлять объекты типа T в любой список, параметризированный любым родительским классом;
    public abstract <T> void three(List destination, List source);

    // должен добавлять любых наследников типа T в список, параметризированный любым родительским классом.
    public abstract <T> void four(List destination, List source);


}
