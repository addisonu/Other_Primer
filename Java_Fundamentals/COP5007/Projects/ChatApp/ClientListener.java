/**
A class that acts as a listner to the client providing the chat app interface
@version 1.0
Project *: 6

FILE NAME: ClientListener.java
DATE: 12/03/15
*/

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientListener implements Runnable{

// INSTANCE VARIABLES //

    /**
    The socket to connect to the server
    */
    private Socket socket;

    /**
    The stream to read data from the server
    */
    private Scanner inFromServer;

    /**
    The stream to write data to the server
    */
    private PrintWriter outToServer;

// METHODS //

    /**
    Constructs a ClientListener object and associates it with the socket argument
    @param socket_arg The socket connected to the server
    */
    public ClientListener(Socket socket_arg){
        setSocket(socket_arg);
    }

    /**
    Overriden method of Runnable interface that is run when this objects thread is started
    */
    public void run(){
        try{
            try{
                inFromServer = new Scanner(socket.getInputStream());
                outToServer = new PrintWriter(socket.getOutputStream());
                catchChat();
            }
            finally{
                socket.close();
                inFromServer.close();
                outToServer.close();
            }
        }
        catch(Exception e){
            System.out.println("There has been an error. The program will now exit.");
        }
    }

    /**
    Will read from and write to the server
    */
    public void catchChat(){
        while(true){
            if(!inFromServer.hasNext()){
                outToServer.println("No message from client");
                outToServer.flush();
                return;
            }
            else{
                String response = inFromServer.nextLine();
                if(response.equals("Quitting...")){
                    System.out.println(response);
                }
                else{
                    System.out.println("Response : " + response);
                }
            }
        }
    }

    /**
    Returns the instance variable socket
    */
    public Socket getSocket(){
        return socket;
    }

    /**
    Sets the instance variable socket
    @param socket_arg The socket connected to the server
    */
    public void setSocket(Socket socket_arg){
        socket = socket_arg;
    }
}
