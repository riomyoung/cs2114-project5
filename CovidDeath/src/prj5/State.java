package prj5;

public class State {
    
    private LinkedList<RaceData> races;
    private String name;
    
    public State( String newName, LinkedList<RaceData> newRaces )
    {
        name = newName;
        races = newRaces;
    }
    
    public State( String newName )
    {
        name = newName;
        races = new LinkedList<RaceData>();
    }
    
    public LinkedList<RaceData> getRaces()
    {
        return races;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void addRace( RaceData newRace )
    {
        races.add( newRace );
    }
    public void setRaces(LinkedList<RaceData> newRaces )
    {
        races = newRaces;
    }
    public String toString()
    {
        return "";
    }

}
