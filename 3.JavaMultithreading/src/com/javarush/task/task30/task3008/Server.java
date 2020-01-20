package com.javarush.task.task30.task3008;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Handler;

public class Server {
    public static void main(String[] args) {

    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public static void main(String[] args) {
            /// ВСЕ ПО ПУНКТАМ, А ВАЛЯ НЕ ПРИНЯЛ
            // Запрашивать порт сервера, используя ConsoleHelper.
            int port = ConsoleHelper.readInt();
            // Создавать серверный сокет java.net.ServerSocket, используя порт из предыдущего пункта.
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(port);
                // Выводить сообщение, что сервер запущен.
                System.out.println("Server Started");

                // В бесконечном цикле слушать и принимать входящие сокетные соединения
                // только что созданного серверного сокета.
                while (true) {
                    // Создавать и запускать новый поток Handler, передавая в конструктор сокет из предыдущего пункта.
                    Handler handler = new Handler(serverSocket.accept());
                    handler.start();
                }
                // Предусмотреть закрытие серверного сокета в случае возникновения исключения.
            } catch (Exception e) {
                ConsoleHelper.writeMessage(e.toString());
                e.printStackTrace();
                try {
                    serverSocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } finally {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//            try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
////                System.out.println("Сервер запущен.");
//                while (true) {
//                    new Handler(serverSocket.accept()).start();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }

//        public static void main(String[] args) throws IOException {
//            System.out.print("Введите порт сервера: ");
//            int port = ConsoleHelper.readInt();
//
//            try (ServerSocket server = new ServerSocket(port);
//                 Socket socket = server.accept();
//                 PrintWriter out = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()), true);
//                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
//                System.out.println("сервер запущен");
//                Handler handler = new Handler(socket);
//                String word;
//                while (true) {
//                    word = in.readLine();
//                    System.out.println("юзер написал: " + word);
//                    out.println("Вы написали: " + word);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }
}
