package com.javarush.task.task29.task2908;

import java.util.concurrent.*;

/* Argument and Value are generic types*/
// Обобщенный параметрезированный дженерик класс _ Argument и Value - есть его параметры
public class CacheComputeManager<Argument, Value> implements Computable<Argument, Value> {
    private final ConcurrentHashMap<Argument, Future<Value>> cache = new ConcurrentHashMap<>();
    private final Computable<Argument, Value> computable;

    public CacheComputeManager(Computable<Argument, Value> computable) {
        this.computable = computable;
    }

    @Override
    public Value compute(final Argument arg) throws InterruptedException {
        Future<Value> f = cache.get(arg); // получаем Future из мапы, по номеру индекса
        if (f == null) {
            FutureTask<Value> ft = createFutureTaskForNewArgumentThatHasToComputeValue(arg);
            cache.putIfAbsent(arg, ft); // добавляет связку ключ-значение, если такого ключа ранее не было
            f = ft;
            ft.run(); // почему run(), вместо start() - !?
            System.out.print(arg + " will be cached  ");
        } else {
            System.out.print(arg + " taken from cache  ");
        }
        try {
            return f.get();
        } catch (CancellationException e) {
            cache.remove(arg, f);
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
        return null;
    }

    public FutureTask<Value> createFutureTaskForNewArgumentThatHasToComputeValue(final Argument arg) {
        //  непнял как из дженериков Argument необходимо получить Value _ где их связь!?
        // Argument arg - на входе с цикла сюда идет значение типа int
        // Value - идет значением в мапу cache

        // Получаем Callable объект
//        Callable<Value> callable = new MyCallable();
//        // Получаем FutureTask из Callable _ где здесь место для Argument!??
//        FutureTask<Value> future = new FutureTask<>(callable);

        // копи паста
        FutureTask<Value> result = new FutureTask<>(new Callable<Value>() {
            @Override
            public Value call() throws Exception {
                // т.е. выоплняется дествие в соответствии с отправленным Сomputable в конструктор
                return computable.compute(arg);
            }
        });

        return result;
    }

//    public class MyCallable implements Callable<Value> {
//
//        @Override
//        public Value call() throws Exception {
//            return null;
//        }
//    }
}
