package us.kardol.cta;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Guillermo Kardolus
 * 
 * Documentation: 
 * http://www.transitchicago.com/developers/ttdocs/default.aspx
 * 
 */

public class TrainTracker {
    private Integer mapId, stopId, maxResults, runNumber;
    private String key, stringUrl, routeCode;
    private Caller caller = new Caller();
    private Utils utils = new Utils();
    
    public String getArrivals(){
        this.stringUrl = "http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx?";
        this.stringUrl = builtUrl();

        if(this.stopId == null && this.mapId == null){
            throw new IllegalStateException();
        }
        
        return caller.getResponse(this.stringUrl);
    }
    
    public String followThisTrain(){
        this.stringUrl = "http://lapi.transitchicago.com/api/1.0/ttfollow.aspx?";
        this.stringUrl = builtUrl();
        
        if(this.runNumber == null){
            throw new IllegalStateException();
        }
        
        return caller.getResponse(this.stringUrl);
    }
    
    public String getLocations(){
        this.stringUrl = "http://lapi.transitchicago.com/api/1.0/ttpositions.aspx?";
        this.stringUrl = builtUrl();
        
        if(this.routeCode == null){
            throw new IllegalStateException();
        }
        
        return caller.getResponse(this.stringUrl);
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
    public void setRouteCode(String code){
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
    public String getRouteCode(){
        return this.routeCode;
    }
    public Integer getRunNumber(){
        return this.runNumber;
    }
    
    private String builtUrl(){
        SortedMap<String, String> params = new TreeMap<>();
        
        if (this.key == null){
            throw new IllegalStateException();
        }

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
            params.put("rt", this.routeCode);
        }

        return this.stringUrl + utils.canonicalize(params);
    }
}
