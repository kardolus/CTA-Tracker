package us.kardol.cta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Guillermo Kardolus
 */
public class Caller {
    public InputStream getResponse(String myUrl){
        try {
            URL url = new URL(myUrl);
            URLConnection conn = url.openConnection();
            conn.setDoInput(true);
            return conn.getInputStream();      
        } catch (MalformedURLException ex) {
            Logger.getLogger(Caller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Caller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
