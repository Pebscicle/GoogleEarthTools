

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
 



    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    @Test
    public void testModifyLongitude() {
        // Test basic modification of longitude by 1 unit.
        Coordinates expectedCoordinates = new Coordinates(-82.19729252446626, 42.55435757233726, 0);
        Coordinates coordinates = new Coordinates(-83.19729252446626, 42.55435757233726, 0);
        coordinates.modifyLongitude(1);
        assertTrue(coordinates.X() == expectedCoordinates.X());
    
        // Test edge case where adding 1 unit to the longitude results in a wrap-around to -180.
        expectedCoordinates = new Coordinates(180, 0, 0);
        coordinates = new Coordinates(179, 0, 0);
        coordinates.modifyLongitude(1);
        assertTrue(coordinates.X() == expectedCoordinates.X());
    
        // Test edge case where subtracting 1 unit from the longitude results in a wrap-around to 180.
        expectedCoordinates = new Coordinates(-180, 0, 0);
        coordinates = new Coordinates(-179, 0, 0);
        coordinates.modifyLongitude(-1);
        assertTrue(coordinates.X() == expectedCoordinates.X());
    
        // Test modification of longitude by 1 unit when close to the valid range boundaries.
        expectedCoordinates = new Coordinates(-179.5, 0, 0);
        coordinates = new Coordinates(179.5, 0, 0);
        coordinates.modifyLongitude(1);
        assertTrue(coordinates.X() == expectedCoordinates.X());
    
        // Test multiple cycles around Earth (361 units), expecting no change in longitude.
        expectedCoordinates = new Coordinates(-179.5, 0, 0);
        coordinates = new Coordinates(179.5, 0, 0);
        coordinates.modifyLongitude(361);
        assertTrue(coordinates.X() == expectedCoordinates.X());
    
        // Test modification of longitude by -1 unit when close to the valid range boundaries.
        expectedCoordinates = new Coordinates(179.5, 0, 0);
        coordinates = new Coordinates(-179.5, 0, 0);
        coordinates.modifyLongitude(-1);
        assertTrue(coordinates.X() == expectedCoordinates.X());
    
        // Test multiple cycles around Earth (-361 units), expecting no change in longitude.
        expectedCoordinates = new Coordinates(179.5, 0, 0);
        coordinates = new Coordinates(-179.5, 0, 0);
        coordinates.modifyLongitude(-361);
        assertTrue(coordinates.X() == expectedCoordinates.X());
    }


}
