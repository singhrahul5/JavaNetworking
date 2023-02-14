package URLConnectionClass;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionClass1 {
    public static void main(String[] args) {

        try{
            URL url = new URL("https://www.javatpoint.com/java-http-url-connection");
            URLConnection urlConnection = url.openConnection();

            InputStream stream = urlConnection.getInputStream();

            int i = 1;

            while( (i = stream.read()) != -1){
                System.out.print((char) i);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
