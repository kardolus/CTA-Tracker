package us.kardol.cta;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Guillermo Kardolus
 */
public class TrainTrackerTest {

    TrainTracker tt;
    
    @Before
    public void setUp() {
        tt = new TrainTracker();
        tt.setKey("Invalid_key"); // From CTA docs
    }
    /**
     * Test of getArrivals method, of class TrainTracker.
     */
    @Test
    public void testGetArrivals() {
        tt.setMapId(40380);
        tt.setMaxResults(5);
  
        String result = tt.getArrivals();
        
        System.out.print("Test 1...");
        if(!result.contains("<errCd>101</errCd>")){
            assert(result.contains("<destNm>")) : "No connection could be made";
        }
        System.out.println(" ok");
        
        System.out.print("Test 2...");
        assertEquals("http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx?key=" + tt.getKey() + "&mapid=40380&max=5", 
                tt.getStringUrl());
        System.out.println(" ok");
    }
    
    @Test
    public void testFollowThisTrain() {
        tt.setRunNumber(426);
  
        String result = tt.followThisTrain();
 
        System.out.print("Test 3...");
        if(!result.contains("<errCd>101</errCd>")){
            assert(result.contains("No trains with runnumber 426 were found.")) : "No connection could be made";
        }
        System.out.println(" ok");
        
        System.out.print("Test 4...");
        assertEquals("http://lapi.transitchicago.com/api/1.0/ttfollow.aspx?key=" + tt.getKey() + "&runnumber=426", 
                tt.getStringUrl());
        System.out.println(" ok");
    }
 
    @Test
    public void testGetLocations() {
        tt.setRouteCode("red");
        String result = tt.getLocations();
 
        System.out.print("Test 5...");
        if(!result.contains("<errCd>101</errCd>")){
            assert(result.contains("<destNm>")) : "No connection could be made";
        }
        System.out.println(" ok");
        
        System.out.print("Test 6...");
        assertEquals("http://lapi.transitchicago.com/api/1.0/ttpositions.aspx?key=" + tt.getKey() + "&rt=red", 
                tt.getStringUrl());
        System.out.println(" ok");
    }
}
