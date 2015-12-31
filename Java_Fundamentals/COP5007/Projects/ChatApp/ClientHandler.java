/**
A class that interacts with a ClientListener to read and write to the server and clients
@version 1.0
Project *: 6

 FILE NAME: ClientHandler.java
 DATE: 12/03/15
 */

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Observer implements Runnable{

// INSTANCE VARIABLES //

    /**
    Socket connected to the client
    */
    private Socket socket;

    /**
    The stream that reads data from the client
    */
    private Scanner inFromClient;

    /**
    The stream that writes data to the client
    */
    private PrintWriter outToClient;

    /**
    The string to hold messages sent from the server
    */
    private static String message;

// METHODS //

    /**
    Constructs a Clienthandler object connected to clients and observing notifications
    @param socket_arg Socket connected to the client
    @param subject Object that will broadcast to all clients
    */
    public ClientHandler(Socket socket_arg, Subject subject){
        this.subject = subject;
        this.subject.attach(this);
        setSocket(socket_arg);
    }

    /**
    Overriden method of Runnable interface called when this object's thread is started
    */
    public void run(){
        try{
            try{
                inFromClient = new Scanner(socket.getInputStream());
                outToClient = new PrintWriter(socket.getOutputStream());
                doChat();
            }
            finally{
                getSocket().close();
                inFromClient.close();
                outToClient.close();
            }
        }
        catch(Exception e){
            System.out.println("There has been an error. The program will now exit.");
            return;
        }
    }

    /**
    Sends a message to all clients when a change in subject's state occurs
    */
    public void update(){
        sendMessage(message);
    }

    /**
    Writes to and reads from the client
    */
    public void doChat() throws IOException{
        while(true){
            if(!inFromClient.hasNext()){
                sendMessage("No messages sent. Quitting...");
                return;
            }
            setMessage(inFromClient.nextLine());
            if(message.equals("QUIT")){
                sendMessage("Quitting...");
                return;
            }
            else{
                System.out.println(getMessage());
                this.subject.setState();
            }
        }
    }

    /**
    Sets the instance variable message
    @param message_arg holds a string sent from or to client(s)
    */
    public void setMessage(String message_arg){
        message = message_arg;
    }

    /**
    Returns the instance variable message
    */
    public String getMessage(){
        return message;
    }

    /**
    Writes a message to clients
    @param message_arg message to send to client(s)
    */
    public void sendMessage(String message_arg){
        outToClient.println(message_arg);
        outToClient.flush();
    }

    /**
    Returns the instance variable socket
    */
    public Socket getSocket(){
        return socket;
    }

    /**
    Sets the instance variable socket
    @param socket_arg The socket connected to the client
    */
    public void setSocket(Socket socket_arg){
        socket = socket_arg;
    }
}
