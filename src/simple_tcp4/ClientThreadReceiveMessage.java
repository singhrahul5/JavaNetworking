package simple_tcp4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThreadReceiveMessage implements Runnable{

    private Socket socket = null;
    private Client client = null;
    public ClientThreadReceiveMessage(Socket socket, Client client) {
        this.socket = socket;
        this.client = client;
    }

    @Override
    public void run() {
//        Input Buffer
        try{
            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message_received = "";
            do {
                message_received = in_socket.readLine().trim();
                System.out.println("Received: " + message_received);
//                Thread.sleep(200);
            } while(!socket.isClosed() && !(message_received.equalsIgnoreCase("exit")) );

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
