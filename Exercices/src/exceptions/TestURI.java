package exceptions;

import java.net.URI;
import java.net.URISyntaxException;

public class TestURI {
    public static void main(String[] args) {
        String aURIString = "http ://somehost:80/path?thequery";
        URI uri;
        try{

            uri = new URI(aURIString);
            System.out.println("URL Valide");
        }catch(URISyntaxException e){
            System.err.println("URL Non-Valide");
        }



    }

}
