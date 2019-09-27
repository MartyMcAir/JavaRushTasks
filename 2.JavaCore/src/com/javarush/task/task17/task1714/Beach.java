package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach bb1 = new Beach("one", 3, 10);
        Beach bb2 = new Beach("one", 9, 9);
        System.out.println(bb1.compareTo(bb2));
        System.out.println(bb2.compareTo(bb1));
    }

    @Override
    public synchronized int compareTo(Beach o) {
//        int result1 = (this.getDistance()> o.getDistance()) ? i++ : i--;
        int result = 0;
//        if (this.getDistance() > o.getDistance()) {
//            result++;
//        } else if (o.getDistance() > this.getDistance()) {
//            result--;
//        }
//        if (this.getQuality() > o.getQuality()) {
//            result++;
//        } else if (o.getQuality() > this.getQuality()) {
//            result--;
//        }

        // работает
//        float objNum1 = this.getDistance() + this.getQuality();
//        float objNum2 = o.getDistance() + o.getQuality();
//            result = (int) (objNum1-objNum2);

//        result = Float.compare(o.distance, this.distance);
//        if (result != 0) return result;
//        result = Integer.compare(o.quality, this.quality);
//        if (result != 0) return result;


//        int r = name.compareTo(o.name);
//        if (r > 0) {
//            result++;
//        } else if (r < 0) {
//            result--;
//        }


//        int result1 = this.quality > o.quality ? 1 : this.quality < o.quality ? -1 : 0;
//        int result2 = this.distance > o.distance ? 1 : this.distance < o.distance ? -1 : 0;
//        result = result1 > result1 ? 1 : result1 > result1 ? -1 : 0;

        int sum = 0;
        result = (int) ( o.distance - this.distance);
        sum += result;
        result = this.quality - o.quality;
        sum += result;

        return sum;
//        return result;
    }
}
