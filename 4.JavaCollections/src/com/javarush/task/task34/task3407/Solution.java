package com.javarush.task.task34.task3407;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/* 
Призрачные ссылки
*/
public class Solution {
    public static Helper helper = new Helper();
    public static class Monkey {     }

    public static void main(String args[]) throws InterruptedException {
        helper.startTime(); // System.currentTimeMillis()..
        List<PhantomReference<Monkey>> list = helper.getPopulatedList(); // список объектов призрачныхх ссылок

        // подсчитвает кол-во ссылок в очереди isEnqueued() и выводит в консоль
        //before GC
        helper.checkListWithReferences(list, "before");

        helper.callGC(); // System.gc()..
        // бессконечный цикл добавляет в список объекты на которые, никто не ссылается.. провацирует OutOfMemoryError
        helper.consumeHeap();

        //after GC
        helper.checkListWithReferences(list, "after");
        // убирает из очереди подсчитывает их кол-во, и выводит в консоль
        helper.finish();
    }

    public static class Helper {
        private ReferenceQueue<Monkey> queue = new ReferenceQueue<>();

        private long startTime;

        void startTime() {
            this.startTime = System.currentTimeMillis();
        }

        int getTime() {
            return (int) (System.currentTimeMillis() - startTime) / 1000;
        }

        void callGC() throws InterruptedException {
            System.gc();
            Thread.sleep(1000);
        }

        public ReferenceQueue<Monkey> getQueue() {
            return queue;
        }

        void consumeHeap() {
            try {
                List<Solution> heap = new ArrayList<Solution>(100000);
                while (true) {
                    heap.add(new Solution());
                }
            } catch (OutOfMemoryError e) {
                System.out.println("An out-of-memory exception has occurred");
            }
        }

        public void checkListWithReferences(List<PhantomReference<Monkey>> list, String string) {
            int count = 0;
            for (PhantomReference<Monkey> reference : list) {
                if (reference.isEnqueued()) {
                    count++;
                }
            }

            System.out.println(String.format("The count of enqueued references is %d (%s GC was called)", count, string));
        }

        public List<PhantomReference<Monkey>> getPopulatedList() {
//            ReferenceQueue<Monkey> queue1 = helper.getQueue();
            List<PhantomReference<Monkey>> list = new ArrayList<>();
            for (int i = 0; i < 200; i++) {
                // добавление объекта и его регистрация в очереди _ queue _ что бы
                // JVM знала какую очередь наполнять фантомами,
                // а список хранит ссылки на объекты содержащие фантом, а не саму ссылку на фантома..
                list.add(new PhantomReference<Monkey>(new Monkey(), queue));
            }
            return list;
        }

        public void finish() throws InterruptedException {
            int count = 0;
            while (queue.poll() != null) {
                count++;
            }
            System.out.println(count + " objects are in the phantom reference queue");
            System.out.println("It took " + getTime() + " s");
        }
    }
}
