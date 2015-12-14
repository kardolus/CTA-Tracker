package us.kardol.cta;

import java.io.BufferedReader;
import java.io.IOException;
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
    public String getResponse(String myUrl){
        String xmlResponse = "";

        try {
            URL url = new URL(myUrl);
            URLConnection conn = url.openConnection();
            conn.setDoInput(true);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String chunk = null;
            while ((chunk = in.readLine()) != null) xmlResponse += chunk;
            in.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Caller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Caller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xmlResponse;
    }
}
