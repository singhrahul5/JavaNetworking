package bonus_Example_2a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class ServerThread implements Runnable {

    private Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            int client_number = ServerMain.getClient_number();
            System.out.println("Client " + client_number + " has connected.");

            //  I/O buffer
            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

            Random random = new Random();
            int secrete_number = random.nextInt(20) + 1;

            String message ;
            do {
                out_socket.println("Guess a number [1 - 20]: ");
                message = in_socket.readLine();
            } while(!(Integer.parseInt(message) == secrete_number));

            out_socket.println("You got it!!");
            System.out.println("Client " + client_number + "'s secrete number has out.");

            socket.close();
            System.out.println("Client " + client_number + " has disconnected.");

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
