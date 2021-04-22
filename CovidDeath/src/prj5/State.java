package prj5;

/**
 * Creates State object that will contain a
 *  LinkedList of RaceData objects
 *
 * @author Rio Young  (riomyoung)
 * @version 2021.04.21
 */
public class State {
    
    private LinkedList<RaceData> races;
    private String name;
    
    /**
     * New State object.
     * 
     *@param newName
     *      name of state
     *@param newRaces
     *      list of races
     *      
     */
    public State( String newName, LinkedList<RaceData> newRaces )
    {
        name = newName;
        races = newRaces;
    }
    
    /**
     * New State object by name only
     * 
     *@param newName
     *      name of state
     *      
     */
    public State( String newName )
    {
        this( newName, new LinkedList<RaceData>() );
    }
    
    /**
     * Returns LinkedList of races for state
     * 
     *@return races
     *      
     */
    public LinkedList<RaceData> getRaces()
    {
        return races;
    }
    
    /**
     * Returns name of state
     * 
     *@param name
     *      
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Adds new race to the state
     * 
     *@param newRace
     *      race to be added
     *      
     */
    public void addRace( RaceData newRace )
    {
        races.add( newRace );
    }
    
    /**
     * Sets list of races to new list
     * 
     *@param newRaces
     *      list of new races
     *      
     */
    public void setRaces(LinkedList<RaceData> newRaces )
    {
        races = newRaces;
    }

}
