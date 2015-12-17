package us.kardol.cta;

import com.transitchicago.arrivals.TrainArrival;
import com.transitchicago.locations.TrainLocation;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author Guillermo Kardolus
 */
public class TrainTrackerTest {
    TrainTracker tt;
    
    @Before
    public void setUp() {
        tt = new TrainTracker();
        tt.setKey("invalid_key");
    }

    @Test
    public void testGetArrivals() {
        tt.setMapId(40380);
        tt.setMaxResults(5);
  
        TrainArrival result = tt.getArrivals();

        System.out.print("Test 1...");
 
        assert(result.getErrCd() == 101 || !result.getEta().isEmpty()) : "No connection could be made";
     
        System.out.println(" ok");
        
        System.out.print("Test 2...");
        assertEquals("http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx?key=" + tt.getKey() 
                + "&mapid=" + tt.getMapId() + "&max=" + tt.getMaxResults(), 
                tt.getStringUrl());
        System.out.println(" ok");
    }
    
    @Test
    public void testFollowThisTrain() {
        tt.setRunNumber(1);
  
        String result = tt.followThisTrain();
        
        System.out.print("Test 3...");
        if(!result.contains("<errCd>101</errCd>")){ // invalid key
            assert(result.contains("<errCd>501</errCd>")) : "No connection could be made";
        }
        System.out.println(" ok");
        
        System.out.print("Test 4...");
        assertEquals("http://lapi.transitchicago.com/api/1.0/ttfollow.aspx?key=" + tt.getKey() 
                + "&runnumber=" + tt.getRunNumber(), 
                tt.getStringUrl());
        System.out.println(" ok");
    }
 
    @Test
    public void testGetLocations() {
        tt.setRouteCode("red");
        TrainLocation result = tt.getLocations();
 
        System.out.print("Test 5...");
        assert(result.getErrCd() == 101 || !result.getRoute().isEmpty()) : "No connection could be made";
        System.out.println(" ok");
        
        System.out.print("Test 6...");
        assertEquals("http://lapi.transitchicago.com/api/1.0/ttpositions.aspx?key=" + tt.getKey() 
                + "&rt=" + tt.getRouteCode(), 
                tt.getStringUrl());
        System.out.println(" ok");
    }
}
