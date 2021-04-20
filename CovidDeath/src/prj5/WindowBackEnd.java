package prj5;

import java.util.Comparator;

public class WindowBackEnd {

    private LinkedList<State> stateList;
    
    public WindowBackEnd(LinkedList<State> states) 
    {
        stateList = states; 
    }
    
    public LinkedList<State> getList()
    {
        return stateList;
    }
    
    public void sort( Comparator<RaceData> comparator )
    {
        
    }
}
