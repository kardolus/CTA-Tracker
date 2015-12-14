package us.kardol.cta;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Guillermo Kardolus
 * 
 * Documentation: 
 * http://www.transitchicago.com/assets/1/developer_center/BusTime_Developer_API_Guide.pdf
 */
public class BusTracker {
    private String  key, stringUrl, routeCode, vehicleId, direction,
                    patternId, stopId, maxResults, singleRouteDirection;
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
    
    /**
     * Use the getstops request to retrieve the set of stops for the specified 
     * route and direction.
     * Stop lists are only available for a valid route/direction pair. In other 
     * words, a list of all stops that service a particular route (regardless of 
     * direction) cannot be requested.
     * @return XML response from CTA 
     */
    public String getStops(){
        this.stringUrl = "http://www.ctabustracker.com/bustime/api/v1/getstops?";
        this.stringUrl = builtUrl();
        
        if(this.getRouteCode() == null || this.getDirection() == null){
            throw new IllegalStateException();
        }
        
        return caller.getResponse(this.stringUrl);
    }
    
    /**
     * Use the getpatterns request to retrieve the set of geo-positional points 
     * and stops that when connected can be used to construct the geo-positional 
     * layout of a pattern (i.e., route variation). Use pid to specify one or 
     * more identifiers of patterns whose points are to be returned. A maximum 
     * of 10 patterns can be specified. Use rt to specify a route identifier 
     * where all active patterns are returned. The set of active patterns 
     * returned includes: one or more patterns for the specified route (all 
     * patterns that are currently being executed by at least one vehicle on the 
     * specified route).
     * 
     * Note: The pid and rt parameters cannot be combined in one request. If 
     * both parameters are specified on a request to getpatterns, only the first 
     * parameter specified on the request will be processed.
     * 
     * @return XML response from CTA 
     */
    public String getPatterns(){
        this.stringUrl = "http://www.ctabustracker.com/bustime/api/v1/getpatterns?";
        this.stringUrl = builtUrl();
        
        return caller.getResponse(this.stringUrl);
    }
    
    /**
     * Use the getpredictions request to retrieve predictions for one or more 
     * stops or one or more vehicles. Predictions are always returned in 
     * ascending order according to prdtm. Use the vid parameter to retrieve 
     * predictions for one or more vehicles currently being tracked. A maximum 
     * of 10 vehicles can be specified. Use the stpid parameter to retrieve 
     * predictions for one or more stops. A maximum of 10 stops can be 
     * specified.
     * 
     * Note: The vid and stpid parameters cannot be combined in one request. If 
     * both parameters are specified on a request to getpredictions, only the 
     * first parameter specified on the request will be processed. All call to 
     * getpredictions without specifying the vid or stpid parameter is not 
     * allowed.
     * Use the top parameter to specify the maximum number of predictions to 
     * return. If top is not specified, then all predictions matching the 
     * specified parameters will be returned.
     * 
     * @return XML response from CTA 
     */
    public String getPredictions(){
        this.stringUrl = "http://www.ctabustracker.com/bustime/api/v1/getpredictions?";
        this.stringUrl = builtUrl();
        
        return caller.getResponse(this.stringUrl);
    }
    
    /**
     * Use the getservicebulletins for a list of service bulletins that are in 
     * effect for a route(s) (rt), route & direction (rt & rtdir), route & 
     * direction & stop (rt & rtdir & stpid), or stop(s) (stpid). At a minimum, 
     * the rt or stpid parameter must be specified. A service bulletin (sb) 
     * definition without a srvc element indicates a “system-wide” service 
     * bulletin. System-wide service bulletins are valid for all routes/stops 
     * in the system.
     * 
     * @return XML response from CTA
     */
    public String getServiceBulletins(){
        this.stringUrl = "http://www.ctabustracker.com/bustime/api/v1/getservicebulletins?";
        this.stringUrl = builtUrl();
        
        if(this.getStopId() == null && this.getRouteCode() == null){
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
    public void setDirection(String direction){
        this.direction = direction;
    }
    public void setPatternId(String pattern){
        this.patternId = pattern;
    }
    public void setStopId(String stopId){
        this.stopId = stopId;
    }
    public void setMaxResults(String maxResults){
        this.maxResults = maxResults;
    }
    public void setSingleRouteDirection(String direction){
        this.singleRouteDirection = direction;
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
    public String getDirection(){
        return this.direction;
    }
    public String getPatternId(){
        return this.patternId;
    }
    public String getStopId(){
        return this.stopId;
    }
    public String getMaxResults(){
        return this.maxResults;
    }
    public String getSingleRouteDirection(){
        return this.singleRouteDirection;
    }
    
    private String builtUrl(){
        SortedMap<String, String> params = new TreeMap<>();
        
        if (this.key == null){
            throw new IllegalStateException();
        }

        params.put("key", this.key);
        if(this.getPatternId() != null){
            params.put("pid", this.getPatternId());
        }
        if(this.direction != null){
            params.put("dir", this.direction);
        }
        if(this.routeCode != null){
            params.put("rt", this.routeCode);
        }
        if(this.vehicleId != null){
            params.put("vid", this.vehicleId);
        }
        if(this.getMaxResults() != null){
            params.put("top", this.getMaxResults());
        }
        if(this.getStopId() != null){
            params.put("stpid", this.getStopId());
        }
        if(this.getSingleRouteDirection() != null){
            params.put("Rtdir", this.getSingleRouteDirection());
        }

        return this.stringUrl + utils.canonicalize(params);
    }
}
