package prj5;

import student.TestCase;

/**
 * Tests methods in RaceData
 *
 * @author Rio Young  (riomyoung)
 * @version 2021.04.21
 */
public class RaceDataTest extends TestCase {

    
    /**
     * sets up each test method before it runs
     */
    private RaceData black;

    
    /**
     * Sets up
     */
    public void setUp()
    {
        black = new RaceData( "black", 179563, 13365 );
    }

    /**
     * Tests constructor
     * 
     */
    public void testConstructor()
    {
        RaceData race = new RaceData( "", 0, 0 );
        assertEquals( 1, race.getCases() );
    }
    
    /**
     * Tests getName
     * 
     */
    public void testGetName()
    {
        assertEquals( "black", black.getName() );
    }
    
    /**
     * Tests getCases
     * 
     */
    public void testGetCases()
    {
        assertEquals( 179563, black.getCases() );
    }
    
    /**
     * Tests setCases
     * 
     */
    public void testSetCases()
    {
        black.setCases(1);
        assertEquals( 1, black.getCases() );
        black.setCases(0);
        assertEquals( 1, black.getCases() );
    }
    
    /**
     * Tests getDeaths
     * 
     */
    public void testGetDeaths()
    {
        assertEquals( 13365, black.getDeaths() );
    }
    
    /**
     * Tests setDeaths
     * 
     */
    public void testSetDeaths()
    {
        black.setDeaths(1);
        assertEquals( 1, black.getDeaths() );
    }
    
    /**
     * Tests getCFRatio
     * 
     */
    public void testGetCFRatio()
    {        
        assertEquals( 7.4, black.getCFRatio(), 0.01 );
        black.setCases(-1);
        assertEquals( -1, black.getCases() );
        assertEquals( -1, black.getCFRatio(), 0.01 );
        black.setDeaths(-1);
        assertEquals( -1, black.getDeaths() );
        assertEquals( -1, black.getCFRatio(), 0.01 );
        black.setCases(1);
        assertEquals( 1, black.getCases() );
        assertEquals( -1, black.getCFRatio(), 0.01 );
    }
    
    /**
     * Tests toString
     * 
     */
    public void testToString()
    {
        assertEquals( "black: 179563 cases, 7.4% CFR", black.toString() );
    }
    
}
