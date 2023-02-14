package bonus_Example_2a;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    private static int client_number = 1;
    public int secrete_number;

    public ServerMain() throws Exception {
        ServerSocket server_socket = new ServerSocket(2020);
        System.out.println("Port 2020 is now open.");

        while(true){
            Socket socket = server_socket.accept();
            ServerThread serverThread = new ServerThread(socket);
            Thread thread = new Thread(serverThread);
            thread.start();
        }
    }

    public static int getClient_number(){
        return client_number++;
    }

    public static void main(String[] args) {
        try{
            new ServerMain();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
