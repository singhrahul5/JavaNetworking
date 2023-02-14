package URLConnectionClass;

import java.net.Inet6Address;
import java.net.InetAddress;

public class InetAddressClass {

    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("Host Name: " + ip.getHostName());
            System.out.println("Host Address: " + ip.getHostAddress());

            byte []address = {(byte)157,34,81,(byte)196};
            InetAddress ip2 = InetAddress.getByAddress(address);
            System.out.println("Host Name: " + ip2.getHostName());
            System.out.println("Host Address: " + ip2.getHostAddress());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
