package us.kardol.cta;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Guillermo Kardolus
 * 
 * Documentation: http://www.transitchicago.com/assets/1/developer_center/BusTime_Developer_API_Guide.pdf
 */
public class BusTracker {
    private String key, stringUrl, routeCode, vehicleId;
    private Caller caller = new Caller();
    private Utils utils = new Utils();
    
    /**
    * Use the gettime request to retrieve the current system date and time. 
    * Since BusTime is a timedependent system, it is important to synchronize 
    * your application with BusTime‖s system date and time.
    * @return xml response from cta
    */
    public String getTime(){
        this.stringUrl = "http://www.ctabustracker.com/bustime/api/v1/gettime?";
        this.stringUrl = builtUrl();
        
        return caller.getResponse(this.stringUrl);
    }
    
    /**
    * Use the getvehicles request to retrieve vehicle information 
    * (i.e., locations) of all or a subset of vehicles
    * currently being tracked by BusTime.
    *
    * Use the vid parameter to retrieve information for one or more vehicles 
    * currently being tracked.
    * Use the rt parameter to retrieve information for vehicles currently 
    * running one or more of the specified routes.
    * 
    * @return xml response from cta
    */
    public String getVehicles(){
        this.stringUrl = "http://www.ctabustracker.com/bustime/api/v1/getvehicles?";
        this.stringUrl = builtUrl();
        
        return caller.getResponse(this.stringUrl);
    }
    
    /**
    * Use the getroutes request to retrieve the set of routes serviced by the 
    * system.
    * @return xml response from cta
    */
    public String getRoutes(){
        this.stringUrl = "http://www.ctabustracker.com/bustime/api/v1/getroutes?";
        this.stringUrl = builtUrl();
        
        return caller.getResponse(this.stringUrl);
    }
    
    /**
     * Use the getdirections request to retrieve the set of directions serviced 
     * by the specified route
     * @return xml response from cta
     */
    public String getDirections(){
        this.stringUrl = "http://www.ctabustracker.com/bustime/api/v1/getdirections?";
        this.stringUrl = builtUrl();
        
        if(this.routeCode == null){
            throw new IllegalStateException();
        }
        
        return caller.getResponse(this.stringUrl);
    }
    
    public void setKey(String key){
        this.key = key;
    }
    public void setStringUrl(String url){
        this.stringUrl = url;
    }
    public void setVehicleId(String vehicleId){
        this.vehicleId = vehicleId;
    }
    public void setRouteCode(String routeCode){
        this.routeCode = routeCode;
    }
    public String getKey(){
        return this.key;
    }
    public String getStringUrl(){
        return this.stringUrl;
    }
    public String getVehicleId(){
        return this.vehicleId;
    }
    public String getRouteCode(){
        return this.routeCode;
    }
    
    private String builtUrl(){
        SortedMap<String, String> params = new TreeMap<>();
        
        if (this.key == null){
            throw new IllegalStateException();
        }

        params.put("key", this.key);
        /*
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
        */
        if(this.routeCode != null){
            params.put("rt", this.routeCode);
        }
        if(this.vehicleId != null){
            params.put("vid", this.vehicleId);
        }
        

        return this.stringUrl + utils.canonicalize(params);
    }
}
