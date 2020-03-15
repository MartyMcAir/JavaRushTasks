package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTreeV2 extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root, lastCurrent;
    Entry<String> findIs = null;

    int sizeCounter = 0, levelCounter = 1; // с каждым уровнем, кол-во элементов удваивается
    // сохраняем в список родителей, и при след добавлении _ проверка на то пуста ли очередь Parents
    Queue<Entry<String>> parentsQueue1 = new LinkedList<>();
    Queue<Entry<String>> parentsQueue2 = new LinkedList<>();
    boolean flag = true;

    public CustomTreeV2() { // валидатор потребовал пустй конструктор
        this.root = new Entry<>("theRoot");
        root.level = 0;
//        sizeCounter++;
    }

    public CustomTreeV2(Entry<String> root) {
        this.root = root;
        root.level = 0;
//        sizeCounter++;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int level;
        boolean isCompleteChildes;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
            this.isCompleteChildes = false;
        }

        public boolean isAvailableToAddChildren() {
            // это назвается дизъюнкция _ возвращающий дизъюнкцию полей
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        public String getElementName() {
            return elementName;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "elementName='" + elementName + '\'' +
                    ", level=" + level +
                    '}';
        }
    }

    // добавляет элементы дерева, в качестве параметра принимает имя элемента (elementName),
    // искать место для вставки начинаем слева направо.
    @Override
    public boolean add(String s) {
        lastCurrent = lastCurrent != null ? lastCurrent : root;
        Entry<String> newEntry = new Entry<>(s);
        newEntry.parent = lastCurrent;
        newEntry.level = levelCounter;

        sizeCounter++; // если будет выше, валя не примет

        if (flag) {
            parentsQueue1.add(newEntry); // при след добавлении, он будет parent
            setNewEntry(newEntry);

            if (!parentsQueue2.isEmpty() & lastCurrent == null) { // если очередь не пуста
                lastCurrent = parentsQueue2.poll();
            }
            if (parentsQueue2.isEmpty() & lastCurrent == null) {
                flag = false;
                lastCurrent = parentsQueue1.poll();
                levelCounter++;
            }
            return true;
        }

        if (!flag) {
            parentsQueue2.add(newEntry);
            setNewEntry(newEntry);

            if (!parentsQueue1.isEmpty() & lastCurrent == null) { // если очередь не пуста
                lastCurrent = parentsQueue1.poll();
            } else if (parentsQueue1.isEmpty() & lastCurrent == null) {
                flag = true;
                lastCurrent = parentsQueue2.poll();
                levelCounter++;
            }
            return true;
        }
        return false;
    }

    private void setNewEntry(Entry<String> newEntry) {
        if (lastCurrent.availableToAddLeftChildren) {
            lastCurrent.leftChild = newEntry;
            lastCurrent.availableToAddLeftChildren = false;
        } else if (lastCurrent.availableToAddRightChildren) {
            lastCurrent.rightChild = newEntry;
            lastCurrent.availableToAddRightChildren = false;
            lastCurrent.isCompleteChildes = true;
            lastCurrent = null;
        }
    }

    // возвращает имя родителя элемента дерева, имя которого было полученного в качестве параметра.
    public String getParent(String s) {
        Entry<String> res = null;

        // Обход используя очередь _ валидатор не прошел пишет, что у 129го родитель должен быть 64ый
//        Queue<Entry<String>> queue = new LinkedList<>();
//        Entry<String> current = root;
//        while (current != null) {
//            if (current.getElementName().equals(s)) {
//                res = current.parent;
//                break;
//            }
//
//            if (current.leftChild != null) {
//                queue.add(current.leftChild);
//            }
//            if (current.rightChild != null) {
//                queue.add(current.rightChild);
//            }
//            current = queue.poll();
//        }

        // рекурсивный подход к нахождению родителя _ валидатор прошел
        setFindByRecursive(root, s);
        res = findIs;
        findIs = null;
        return res.getElementName();
        // Другие варианты
        // 1 и 2)Обходы в глубину, или ширину используя метку вершины, true значит посещена..
        // 3) Обход используя знания о том, что с каждым левелом кол-во элементов удваивается..
        //      (и зная это можно предположить, какие числа с левого миним и прав максим на каждом уровне)
    }

    public Entry<String> getEntryMaxLeft() {
        Entry<String> current = root, last = null;
        while (current != null) {
            last = current;
            current = last.leftChild;
        }
        return last;
    }

    private Entry<String> setFindByRecursive(Entry<String> stringEntry, String find) {
//        Entry<String> res = null;
        if (stringEntry != null) {
            boolean equals = stringEntry.getElementName().equals(find);
            if (equals) {
                findIs = stringEntry.parent;
            } else {
                setFindByRecursive(stringEntry.leftChild, find);
                setFindByRecursive(stringEntry.rightChild, find);
            }
        }
        return null; // если не найдено
    }

    // возвращает текущее количество элементов в дереве.
    @Override
    public int size() {
        return sizeCounter;
    }

    /////////////////////////////////////////
    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }
}
