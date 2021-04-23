package prj5;

import java.io.FileNotFoundException;
import student.TestCase;

/**
 * Tests methods in FileParser
 *
 * @author Rio Young  (riomyoung)
 * @version 2321.34.23
 */
public class FileParserTest extends TestCase {
    
    /**
     * sets up each test method before it runs
     */
    private FileParser parser;

    
    /**
     * Sets up
     * @throws FileNotFoundException 
     */
    public void setUp() throws FileNotFoundException
    {
        parser = new FileParser( "Cases_and_Deaths_by_race_CRDT_Sep2020.csv" );
    }
    
    /**
     * Tests FileNotFoundException in constructor
     * @throws FileNotFoundException 
     */
    public void testException()
    {
        Exception exception = null;
        try{
            parser = new FileParser( "aaa" );
        }
        catch (FileNotFoundException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }
    
    public void testGetStates()
    {
//        State newState = new State( "DC");
//        newState.addRace(new RaceData( "white", 73678, 1924 ) );
//        newState.addRace(new RaceData( "black", 179563, 13365 ) );
//        newState.addRace(new RaceData( "latinx", 97118, 2269 ) );
//        newState.addRace(new RaceData( "asian", 5407, 254 ) );
//        newState.addRace(new RaceData( "other", 108784, 173 ) );
        
        State firstState = parser.getStates().getEntry(0);
        LinkedList<RaceData> races = firstState.getRaces();
        
        assertEquals( "DC", firstState.getName() );
        
        assertEquals( "white", races.getEntry(0).getName() );
        assertEquals( 70678, races.getEntry(0).getCases() );
        assertEquals( 1924, races.getEntry(0).getDeaths() );
        
        assertEquals( "black", races.getEntry(1).getName() );
        assertEquals( 179563, races.getEntry(1).getCases() );
        assertEquals( 13365, races.getEntry(1).getDeaths() );
        
        assertEquals( "latinx", races.getEntry(2).getName() );
        assertEquals( 97118, races.getEntry(2).getCases() );
        assertEquals( 2269, races.getEntry(2).getDeaths() );
        
        assertEquals( "asian", races.getEntry(3).getName() );
        assertEquals( 5407, races.getEntry(3).getCases() );
        assertEquals( 254, races.getEntry(3).getDeaths() );
        
        assertEquals( "other", races.getEntry(4).getName() );
        assertEquals( 108784, races.getEntry(4).getCases() );
        assertEquals( 170, races.getEntry(4).getDeaths() );
        
    }
    
    
    
}
