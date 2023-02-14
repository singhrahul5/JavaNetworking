package bonus_Example_1a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() throws Exception{

        ServerSocket server_socket = new ServerSocket(2020);
        System.out.println("Port 2020 is now open.");

        Socket socket = server_socket.accept();
        System.out.println("Client connected successfully");

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

        String message;

        do{
            message = in_socket.readLine();
            System.out.println("Message Received: " + message);
            message = message.toUpperCase();
            out_socket.println(message);
            System.out.println("Message sent: " + message);

        } while(!message.equalsIgnoreCase("exit"));

        socket.close();
        System.out.println("Socket closed.");
    }
    public static void main(String[] args) {
        try {
            new Server();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
