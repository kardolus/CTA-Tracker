package us.kardol.cta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Guillermo Kardolus
 * 
 * Documentation: 
 * http://www.transitchicago.com/developers/ttdocs/default.aspx
 * 
 */

public class TrainTracker {
    private Integer mapId, stopId, maxResults, routeCode, runNumber;
    private String key, stringUrl;
    
    
    public String getArrivals(){
        String xmlResponse = null;
        this.stringUrl = "http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx?";
        this.stringUrl = builtUrl();

        if(this.stopId == null && this.mapId == null){
            throw new IllegalStateException();
        }
        
        return this.getResponse(this.stringUrl);
    }
    
    public String followThisTrain(){
        this.stringUrl = "http://lapi.transitchicago.com/api/1.0/ttfollow.aspx?";
        this.stringUrl = builtUrl();
        
        if(this.runNumber == null){
            throw new IllegalStateException();
        }
        
        return this.getResponse(this.stringUrl);
    }
    
    private String getResponse(String myUrl){
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
            Logger.getLogger(TrainTracker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TrainTracker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xmlResponse;
    }
    
    public void setRunNumber(Integer runMumber){
        this.runNumber = runMumber;
    }
    public void setMapId(Integer id){
        this.mapId = id;
    }
    public void setStopId(Integer id){
        this.stopId = id;
    }
    public void setMaxResults(Integer max){
        this.maxResults = max;
    }
    public void setKey(String key){
        this.key = key;
    }
    public void setRouteCode(Integer code){
        this.routeCode = code;
    }
    public Integer getMapId(){
        return this.mapId;
    }
    public Integer getStopId(){
        return this.stopId;
    }
    public Integer getMaxResults(){
        return this.maxResults;
    }
    public String getKey(){
        return this.key;
    }
    public String getStringUrl(){
        return this.stringUrl;
    }
    public Integer getRouteCode(){
        return this.routeCode;
    }
    public Integer getRunNumber(){
        return this.runNumber;
    }
    
    private String builtUrl(){
        if (this.key == null){
            throw new IllegalStateException();
        }
        
        return this.stringUrl += canonicalize();
    }
    
    private String canonicalize(){
        SortedMap<String, String> params = new TreeMap<>();
        StringBuilder builder = new StringBuilder();
        /*
        private Integer mapId, stopId, maxResults, routeCode;
        private String key;
        */
        params.put("key", this.key);
        if(this.mapId != null){
            params.put("mapid", this.mapId.toString());
        }
        if(this.stopId != null){
            params.put("stpid", this.stopId.toString());
        }
        if(this.maxResults != null){
            params.put("max", this.maxResults.toString());
        }
        if(this.runNumber != null){
            params.put("runnumber", this.runNumber.toString());
        }
        if(this.routeCode != null){
            params.put("rt", this.routeCode.toString());
        }

        if (params.isEmpty()) return "";
        Iterator<Map.Entry<String, String>> iter =
                 params.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> kvpair = iter.next();
            builder.append(encodeRfc3986(kvpair.getKey()));
            builder.append("=");
            builder.append(encodeRfc3986(kvpair.getValue()));
            if (iter.hasNext()) builder.append("&");
        }
        return builder.toString();
    }
    private String encodeRfc3986(String s) {
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
    

}
