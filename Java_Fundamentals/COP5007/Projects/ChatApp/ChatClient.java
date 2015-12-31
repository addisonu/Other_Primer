/**
A client that tests the server
@version 1.0
Project #: 6

FILE NAME: ChatClient.java
DATE: 12/03/15
*/

import java.io.InputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
Program to test the chat server
*/

public class ChatClient{
    public static void main(String[] args) throws IOException{

        try{
// Connect to socket and create streams to server
            final int SCP_PORT = 7777;
            Socket socket = new Socket("localhost", SCP_PORT);
            PrintWriter outToServer = new PrintWriter(socket.getOutputStream());
            Scanner inFromUser = new Scanner(System.in);
            String message, response;

// Create ClientListener
            ClientListener listener = new ClientListener(socket);
            Thread t = new Thread(listener);
            t.start();

// Create infinite loop
            boolean active = true;
            while(active){

// Send message to server
                message = inFromUser.nextLine();
                System.out.println("Sending : " + message);
                outToServer.println(message);
                outToServer.flush();
                if(message.equals("QUIT"))
                    active = false;
            }
        }
        catch(ConnectException e){
            System.out.println("The server is offline. Please try again later.");
        }
        catch(Exception e){
            System.out.println("An error has occurred. The program will now terminate.");
        }
    }
}
