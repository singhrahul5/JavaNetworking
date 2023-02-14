package simple_tcp4;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public ServerMain() throws Exception{
        ServerSocket serverSocket = new ServerSocket(2311);
        System.out.println("Port 2311 is now open.");

        Socket socket = serverSocket.accept();
        System.out.println("Client " + socket.getInetAddress() + " has connected.");
        ThreadReceiveMessage receive = new ThreadReceiveMessage(socket,this);
        Thread thread1 = new Thread(receive);
        thread1.start();

        ThreadSendMessage send = new ThreadSendMessage(socket,this);
        Thread thread2 = new Thread(send);
        thread2.start();

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
