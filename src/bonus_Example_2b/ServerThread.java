package bonus_Example_2b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class ServerThread implements Runnable {

    private Socket socket = null;
    ServerMain serverMain = null;

    public ServerThread(Socket socket, ServerMain serverMain) {
        this.socket = socket;
        this.serverMain = serverMain;
    }

    @Override
    public void run() {
        try{
            int client_number = ServerMain.getClient_number();
            System.out.println("Client " + client_number + " has connected.");

            //  I/O buffer
            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

            out_socket.println("Enter your name: ");
            String name = in_socket.readLine();

            String message ;
            do {
                out_socket.println("Guess a number [1 - 20]: ");
                message = in_socket.readLine().trim();
                if(serverMain.flag)
                    break;

            } while(!(Integer.parseInt(message) == serverMain.secrete_number ));

            if (serverMain.flag){
                out_socket.println("Number is already out, " + serverMain.winner_name + " guess the number first.");
            }
            else{
                serverMain.winner_name = name;
                serverMain.flag =true;
                out_socket.println("You got it!!");
                System.out.println("Client " + name + " has guess the number.");
            }

            socket.close();
            System.out.println("Client " + client_number + " has disconnected.");

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
