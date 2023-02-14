package simple_tcp4;

import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client() throws Exception{
//        Scanner keyboard = new Scanner(System.in);
//        System.out.print("Enter Server ip address: ");
//        String ip = keyboard.nextLine();
//        System.out.print("Enter port: ");
//        int port = Integer.parseInt(keyboard.nextLine().trim());

//        Socket socket = new Socket(ip,port);
        Socket socket = new Socket("localhost",2311);
        System.out.println("Successfully connected to server.");

        ClientThreadSendMessage send = new ClientThreadSendMessage(socket,this);
        Thread thread1 = new Thread(send);
        thread1.start();

        ClientThreadReceiveMessage receive = new ClientThreadReceiveMessage(socket,this);
        Thread thread2 = new Thread(receive);
        thread2.start();

    }
    public static void main(String[] args) {
        try{
            new Client();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
