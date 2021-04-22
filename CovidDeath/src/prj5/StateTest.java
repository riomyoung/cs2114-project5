package prj5;

import student.TestCase;

/**
 * Tests methods in State
 *
 * @author Rio Young  (riomyoung)
 * @version 2021.04.21
 */
public class StateTest extends TestCase {

    /**
     * sets up each test method before it runs
     */
    private State virginia;

    
    /**
     * Sets up
     */
    public void setUp()
    {
        virginia = new State("VA");
    }
    
    /**
     * Tests getName
     * 
     */
    public void testGetName()
    {
        assertEquals( "VA", virginia.getName() );
    }
    
    /**
     * Tests addRace
     * 
     */
    public void testAddRace()
    {
        assertEquals( 0, virginia.getRaces().size() );
        virginia.addRace( new RaceData( "", 1, 1) );
        assertEquals( 1, virginia.getRaces().size() );
    }

    /**
     * Tests setRaces
     * 
     */
    public void testSetRaces()
    {
        LinkedList<RaceData> list = new LinkedList<RaceData>();
        list.add( new RaceData( "", 1, 1));
        virginia.setRaces(list);
        assertEquals( 1, virginia.getRaces().size() );
    }

}
