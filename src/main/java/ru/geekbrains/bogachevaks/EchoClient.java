package ru.geekbrains.bogachevaks;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    //private final Object mon = new Object();

    public static void main(String[] args) {
        new EchoClient().start();
    }

    private void start() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("1");
                sendMessage(scanner.nextLine());
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    private void sendMessage(String message) {
        try{
            out.writeUTF(message);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void openConnection() throws IOException {
        socket = new Socket("127.0.0.1", 8189);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(() -> {
            try {
                while (true) {
                    String message = in.readUTF();
                    if ("/end".equalsIgnoreCase(message)){
                        break;
                    }
                    System.out.println("Coобщение от сервера: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }).start();
    }

    private void closeConnection() {
        if(in != null){
            try{
                in.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(out != null){
            try{
                out.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(socket != null){
            try{
                socket.close();
                System.out.println("close = " + socket.isClosed());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
