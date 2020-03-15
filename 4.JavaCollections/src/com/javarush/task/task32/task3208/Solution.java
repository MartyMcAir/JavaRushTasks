package com.javarush.task.task32.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

/* 
RMI-2
*/
public class Solution {
    public static Registry registry;
    public static final String UNIC_BINDING_NAME1 = "Cat Kayle"; /////////
    public static final String UNIC_BINDING_NAME2 = "Dog Amorous"; /////////

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //напишите тут ваш код
            try {
                // создание объекта для удаленного доступа
                Cat cat = new Cat("Kayle"); // а клиент берет интерфейс, который реализ эти классы..
                Dog dog = new Dog("Amorous");

                // создание реестра расшареных объетов
//                Solution.registry = LocateRegistry.getRegistry(2099); // эта конструкция для клиента
                registry = LocateRegistry.createRegistry(2099);

                // создание "заглушки" – приемника удаленных вызовов
                // объекты сериализуются (т.к. пересылать можно ток при сериализац из JRush)
                Remote remoteCat = UnicastRemoteObject.exportObject(cat, 0);
                Remote remoteDog = UnicastRemoteObject.exportObject(dog, 0);

                // регистрация "заглушки" в реесте
                registry.bind(UNIC_BINDING_NAME1, remoteCat);
                registry.bind(UNIC_BINDING_NAME2, remoteDog);
            } catch (RemoteException | AlreadyBoundException e) {
                e.printStackTrace();
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        // Start the client
        CLIENT_THREAD.start();
    }
}