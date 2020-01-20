package com.javarush.task.task24.task2413;

// Во-первых для простоты считать что все объекты у нас будут круглыми.
//Нет, отрисовывать их мы будем фигурными, как и раньше.
//А вот при расчетах из взаимодействия исходить из того, что они круглые.
//Так - гораздо проще.
//
//Во-вторых. Пусть координаты объектов и радиус будут вещественными числами.
//Это придаст плавность движениям и точность всем вычислениям.
//А при отрисовке мы будем их округлять.
public abstract class BaseObject {
    private double x, y, radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    // А еще нам нужно будет определять попал ли шарик в кирпич или в подставку.
    public boolean isIntersec(BaseObject o) {
        boolean result = false;
        // sqrt() - Возвращает квадратный корень аргумента.
        // pow() - Возвращает значение первого аргумента, возведенное в степень второго аргумента.
        double distance = Math.sqrt(Math.pow((this.x - o.x), 2) + Math.pow((this.y - o.y), 2));
//        Если дистанция меньше радиуса одного из объедков, то результат true.
        if (distance <= this.radius || distance <= o.radius) {
            result = true;
        }
        return result;
//        return distance <= o.getRadius() || distance <= this.radius;
//        return StrictMath.sqrt((o.getX()-x)*(o.getX()-x) + (o.getY()-y)*(o.getY()-y) ) <= (o.getRadius() > radius ? o.getRadius() : radius);
    }

    ////////////////
    public abstract void draw(Canvas canvas);

    public abstract void move();

    ////////////////////////
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
