package us.kardol.cta;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guillermo Kardolus
 */
public class BusTrackerTest {
    BusTracker bt;
    public BusTrackerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        bt = new BusTracker();
        bt.setKey("a8456dcbhf8475683cf7818bca81"); // From CTA docs
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTime method, of class BusTracker.
     */
    @Test
    public void testGetTime() {
        String result = bt.getTime();
        
        System.out.print("Test 1...");
        assert(result.contains("Invalid API access key")) : "Example key should not be valid";
        System.out.println(" ok");
        
        System.out.print("Test 2...");
        assertEquals("http://www.ctabustracker.com/bustime/api/v1/gettime?key=a8456dcbhf8475683cf7818bca81", 
                bt.getStringUrl());
        System.out.println(" ok");
    }

    @Test
    public void testGetVehicles() {
        bt.setVehicleId("509,392");
  
        String result = bt.getVehicles();
        
        System.out.print("Test 3...");
        assert(result.contains("Invalid API access key")) : "Example key should not be valid";
        System.out.println(" ok");
        
        System.out.print("Test 4...");
        assertEquals("http://www.ctabustracker.com/bustime/api/v1/getvehicles?key=a8456dcbhf8475683cf7818bca81&vid=509%2C392", 
                bt.getStringUrl());
        System.out.println(" ok");
    }
    
    @Test
    public void testGetRoutes() {
        String result = bt.getRoutes();
        
        System.out.print("Test 5...");
        assert(result.contains("Invalid API access key")) : "Example key should not be valid";
        System.out.println(" ok");
        
        System.out.print("Test 6...");
        assertEquals("http://www.ctabustracker.com/bustime/api/v1/getroutes?key=a8456dcbhf8475683cf7818bca81", 
                bt.getStringUrl());
        System.out.println(" ok");
    }
    
    @Test
    public void testGetDirections() {
        bt.setRouteCode("20");
        String result = bt.getDirections();
        
        System.out.print("Test 7...");
        assert(result.contains("Invalid API access key")) : "Example key should not be valid";
        System.out.println(" ok");
        
        System.out.print("Test 8...");
        assertEquals("http://www.ctabustracker.com/bustime/api/v1/getdirections?key=a8456dcbhf8475683cf7818bca81&rt=20", 
                bt.getStringUrl());
        System.out.println(" ok");
    }
    
    @Test
    public void testGetStops() {
        bt.setRouteCode("20");
        bt.setDirection("East Bound");
        String result = bt.getStops();
        
        System.out.print("Test 9...");
        assert(result.contains("Invalid API access key")) : "Example key should not be valid";
        System.out.println(" ok");
        
        System.out.print("Test 10...");
        assertEquals("http://www.ctabustracker.com/bustime/api/v1/getstops?dir=East%20Bound&key=a8456dcbhf8475683cf7818bca81&rt=20", 
                bt.getStringUrl());
        System.out.println(" ok");
    }
    
    @Test
    public void testGetPatterns() {
        bt.setRouteCode("20");
        bt.setPatternId("954");
        String result = bt.getPatterns();
        
        System.out.print("Test 11...");
        assert(result.contains("Invalid API access key")) : "Example key should not be valid";
        System.out.println(" ok");
        
        System.out.print("Test 12...");
        assertEquals("http://www.ctabustracker.com/bustime/api/v1/getpatterns?key=a8456dcbhf8475683cf7818bca81&pid=954&rt=20", 
                bt.getStringUrl());
        System.out.println(" ok");
    }
    
    @Test
    public void testGetPredictions() {
        bt.setRouteCode("20");
        bt.setStopId("456");
        String result = bt.getPredictions();
        
        System.out.print("Test 13...");
        assert(result.contains("Invalid API access key")) : "Example key should not be valid";
        System.out.println(" ok");
        
        System.out.print("Test 14...");
        assertEquals("http://www.ctabustracker.com/bustime/api/v1/getpredictions?key=a8456dcbhf8475683cf7818bca81&rt=20&stpid=456", 
                bt.getStringUrl());
        System.out.println(" ok");
    }
    
    @Test
    public void testGetServiceBulletins() {
        bt.setStopId("456");
        String result = bt.getServiceBulletins();
        
        System.out.print("Test 15...");
        assert(result.contains("Invalid API access key")) : "Example key should not be valid";
        System.out.println(" ok");
        
        System.out.print("Test 16...");
        assertEquals("http://www.ctabustracker.com/bustime/api/v1/getservicebulletins?key=a8456dcbhf8475683cf7818bca81&stpid=456", 
                bt.getStringUrl());
        System.out.println(" ok");
    }
}
