package ru.geekbrains.bogachevaks;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(8189)){
            System.out.println("Ждем подключения клиента...");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            Thread thread = new Thread(() -> {
                while (true) {
                    sendMessage(scanner.nextLine(), out);
                }
            });
            thread.setDaemon(true);
            thread.start();

            while (true){
                String message = in.readUTF();
                if ("/end".equalsIgnoreCase(message)){
                    out.writeUTF("/end");
                    break;
                }
                System.out.println("Coобщение от клиента: [echo]" + message);
                out.writeUTF("[echo]" + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void sendMessage(String message, DataOutputStream out) {
        try{
            out.writeUTF(message);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
