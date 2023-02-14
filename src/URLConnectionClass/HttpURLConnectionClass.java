package URLConnectionClass;

import java.net.*;

public class HttpURLConnectionClass {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.javatpoint.com/java-http-url-connection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection() ;

            for (int i = 1; i<15; i++){
                System.out.println(httpURLConnection.getHeaderFieldKey(i) + "= " + httpURLConnection.getHeaderField(i));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
