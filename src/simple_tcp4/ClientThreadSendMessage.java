package simple_tcp4;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThreadSendMessage implements Runnable{
    private Socket socket = null;
    private Client client = null;
    public ClientThreadSendMessage(Socket socket, Client client){
        this.socket = socket;
        this.client = client;
    }
    @Override
    public void run() {
//        Output Buffer
        try{
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            Scanner keyboard = new Scanner(System.in);
            String send_message = "";

            do {
                send_message = keyboard.nextLine();
                out_socket.println(send_message);
                System.out.println("Sent: " + send_message);
//                Thread.sleep(200);
            } while(!socket.isClosed() && !(send_message.equalsIgnoreCase("exit")) );

            if (!socket.isClosed()){
                socket.close();
                System.out.println("Socket is closed.");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
