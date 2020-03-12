package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

public class Server {

    public static final int PORT = 3456;
    public static ArrayList<OneConnection> serverList = new ArrayList<>(); // список всех нитей

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Сервер запущен");
        try {
            while (true) {
                // Блокируется до возникновения нового соединения:
                Socket socket = server.accept();
                System.out.println("Приконнектились");
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String name = in.readLine();
                System.out.println(name + " " + socket.getInetAddress() + " " + socket.getPort());
                try {
                    serverList.add(new OneConnection(socket, name)); // добавить новое соединенние в список
                    for(OneConnection connection: serverList)
                    {
                        System.out.print(connection.name+" ");
                    }
                } catch (IOException e) {
                    // Если завершится неудачей, закрывается сокет,
                    // в противном случае, нить закроет его при завершении работы:
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}
