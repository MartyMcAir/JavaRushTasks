package com.javarush.task.task30.task3008;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Connection implements Closeable {
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

//    private final Lock lock1 = new ReentrantLock(); // вал хочет без Lock
//    private final Lock lock2 = new ReentrantLock();

    public Connection(Socket socket) throws IOException {
        // Создать объект класса ObjectOutputStream нужно до того,
        // как будет создаваться объект класса ObjectInputStream,
        // иначе может возникнуть взаимная блокировка потоков,
        // которые хотят установить соединение через класс Connection.
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    public void send(Message message) throws IOException {
        synchronized (out) {
            out.writeObject(message);
            out.flush();
        }
    }

    public Message receive() throws IOException, ClassNotFoundException {
        Message res = null;
        synchronized (in) {
            res = (Message) in.readObject();
        }
        return res;
    }

    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }

    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
