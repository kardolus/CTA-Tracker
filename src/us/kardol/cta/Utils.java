
package us.kardol.cta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Guillermo Kardolus
 */
public class Utils {
    public String encodeRfc3986(String s) {
        String out = null;

        try {
            out = URLEncoder.encode(s, "UTF-8")
                    .replace("+", "%20")
                    .replace("*", "%2A")
                    .replace("%7E", "~");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TrainTracker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }
    
    public String canonicalize(SortedMap<String,String> params){
        StringBuilder builder = new StringBuilder();
        if (params.isEmpty()) return "";
        Iterator<Map.Entry<String, String>> iter =
                 params.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> kvpair = iter.next();
            builder.append(this.encodeRfc3986(kvpair.getKey()));
            builder.append("=");
            builder.append(this.encodeRfc3986(kvpair.getValue()));
            if (iter.hasNext()) builder.append("&");
        }
        return builder.toString();
    }
    
    public String inputStreamToString(InputStream xml){
        String xmlString = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(xml));
        String chunk;
        
        try {
            while ((chunk = in.readLine()) != null) xmlString += chunk;
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return xmlString;
    }
}
