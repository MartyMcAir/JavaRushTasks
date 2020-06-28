package com.javarush.task.task40.task4004;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/* 
Принадлежность точки многоугольнику
*/
// Дан многоугольник, заданный координатами своих вершин.
//Ребра многоугольника не пересекаются.
//Необходимо реализовать метод isPointInPolygon(Point point, List<Point> polygon), который проверит, принадлежит ли переданная точка многоугольнику.
//Для граничных точек принадлежность не определена: isPointInPolygon может вернуть как true так и false.
// https://javarush.ru/tasks/com.javarush.task.task40.task4004#discussion

// http://grafika.me/node/529
class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
//        polygon.add(new java.awt.Point(0, 0));  // del
//        polygon.add(new java.awt.Point(0, 10)); // del
        polygon.add(new Point(0, 0)); //
        polygon.add(new Point(0, 10)); //
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));

        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
        System.out.println(isPointInPolygon(new Point(100, 100), polygon));
    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
        //напишите тут ваш код
        return new Polygon(polygon.stream().mapToInt(i -> i.x).toArray()
                ,polygon.stream().mapToInt(i -> i.y).toArray(),
                polygon.size()).contains(new java.awt.Point(point.x, point.y));
    }


    // From https://javarush.ru/tasks/com.javarush.task.task40.task4004#discussion ...
    // Да, для решения задачи достаточно всего лишь:
    //1. Почитать, как получить уравнение прямой по двум точкам
    //2. Почитать, как найти пересечение двух прямых
    //3. Выяснить, как узнать, что точка перечения находится на отрезке.
    //4. Сосчитать количество пересечений "лучом" граней.
    //5. Открыть документацию по классу Полигон
    // (https://docs.oracle.com/javase/7/docs/api/java/awt/Polygon.html) и написать три строки кода.

    // Окей, вот мой велосипед:
    //1. Создал "карту" Color[][]. Что за Color? Скажу позже, если еще не поняли.
    //2. Отобразил на ней вершины. От этих вершин провел прямые (построил цепь, периметр).
    //3. Осталось залить фигуру. "Программист решает проблему только один раз" - поэтому я взял классы Color и PhotoPaint из задачи "Залей меня полностью", указал некоторую точку, отложенную от построения первой прямой и залил.
    //4. Проверил цвет точки из задания. Если это цвет заливки - true.
    //А теперь пошел переделывать через полигоны. Спасибо)
}

