package com.javarush.task.task25.task2507;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/* 
Работать в поте лица!
*/
public class Solution extends Thread {
    private static final int BUFFER_SIZE = 2000;    //2000 bytes
    private final Socket socket;
    private final InputStream in;

    public Solution(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt() {
        //implement logic here
        try {
            this.in.close();
            this.socket.close();
            System.out.println("socket is finally");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            super.interrupt();
            System.out.println("socket is interrupted");
        }
    }

    public void run() {
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else {
                    if (count > 0) {
                        //process buffer here
                    }
                }
            }
        } catch (IOException ignored) {
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket soc = new Socket("localhost", 80);
//        soc.getInetAddress();
        Solution sol = new Solution(soc);
        sol.start();

        Thread.sleep(500);
        sol.interrupt();

    }
}
