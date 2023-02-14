package bonus_Example_1a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client() throws Exception {
        Socket socket = new Socket("localhost",2020);
        System.out.println("Successfully connected to the Server.");

        //  I/O Buffers:
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        Scanner keyboard = new Scanner(System.in);

        String message;
        do {
            System.out.print("Enter a message for Server: ");
            message = keyboard.nextLine();
            out_socket.println(message);
            System.out.println("Message sent: " + message);

            message = in_socket.readLine();
            System.out.println("Message Received: " + message);
        } while (!(message.equals("EXIT")));


        socket.close();
        System.out.println("Socket Closed.");
    }
    public static void main(String[] args) {
        try{
            new Client();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
