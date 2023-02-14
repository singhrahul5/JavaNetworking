package bonus_Example_2b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client() throws Exception {
        Socket socket = new Socket( "localhost",2020);
        System.out.println("Successful connection to the server.");

        //  I/O Stream
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner keyboard = new Scanner(System.in);

        System.out.print(in_socket.readLine());
        out_socket.println(keyboard.nextLine());

        String user_number;
        String write ;
        while((write = in_socket.readLine()).startsWith("Guess")){
            System.out.print("Server says: " + write);
            user_number = keyboard.nextLine();
            out_socket.println(user_number);
        }

        System.out.println( write );
        socket.close();
        System.out.println("Socket closed");
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
