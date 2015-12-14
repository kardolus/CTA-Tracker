package us.kardol.cta;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author misterclipping
 */
public class TrainTrackerTest {
    
    public TrainTrackerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getArrivals method, of class TrainTracker.
     */
    @Test
    public void testGetArrivals() {
        TrainTracker tt = new TrainTracker();
        tt.setKey("a8456dcbhf8475683cf7818bca81"); // From CTA docs
        tt.setMapId(40380);
        tt.setMaxResults(5);
  
        String result = tt.getArrivals();
        
        System.out.print("Test 1...");
        assert(result.contains("Invalid API key")) : "Example key should not be valid";
        System.out.println(" ok");
        
        System.out.print("Test 2...");
        assertEquals("http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx?key=a8456dcbhf8475683cf7818bca81&mapid=40380&max=5", 
                tt.getStringUrl());
        System.out.println(" ok");
    }
    
    @Test
    public void testFollowThisTrain() {
        TrainTracker tt = new TrainTracker();
        tt.setKey("a8456dcbhf8475683cf7818bca81"); // From CTA docs
        tt.setRunNumber(426);
  
        String result = tt.followThisTrain();
 
        System.out.print("Test 3...");
        assert(result.contains("Invalid API key")) : "Example key should not be valid";
        System.out.println(" ok");
        
        System.out.print("Test 4...");
        assertEquals("http://lapi.transitchicago.com/api/1.0/ttfollow.aspx?key=a8456dcbhf8475683cf7818bca81&runnumber=426", 
                tt.getStringUrl());
        System.out.println(" ok");
    }
 
   
}
