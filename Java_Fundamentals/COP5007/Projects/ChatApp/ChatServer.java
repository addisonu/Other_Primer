/**
A server that executes the simple chat protocol
@version 1.0
Project *: 6

FILE NAME: ChatServer.java
DATE: 12/03/15
*/

import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
Program to test the chat client
*/

public class ChatServer{
    public static void main(String[] args) throws IOException{

// connect to socket
        final int SCP_PORT = 7777;
        ServerSocket server = new ServerSocket(SCP_PORT);
        System.out.println("Waiting for clients to connect...");

// Create subject to update ClientHandlers
    Subject subject = new Subject();

// start infinte loop
        while(true){

// wait for client connection
            Socket s = server.accept();
            System.out.println("Client connected");

// create client handler and pass it to new thread
            if(s.isBound()){
                ClientHandler handler = new ClientHandler(s, subject);
                Thread t = new Thread(handler);
                t.start();
            }
        }
    }
}
