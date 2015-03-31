package DomaineRoute;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Théo Vaucher on 31/03/2015.
 */
public class TestRoute {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCreationRoute() {
        Route route = new Route(20,50,300,30);

        assertEquals(20, route.getX());
        assertEquals(50, route.getY());
        assertEquals(300, route.getWidth());
        assertEquals(30, route.getHeight());
    }
}
