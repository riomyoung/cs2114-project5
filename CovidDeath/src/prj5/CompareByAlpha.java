package prj5;

import java.util.Comparator;

public class CompareByAlpha implements Comparator<RaceData> {

    @Override
    public int compare(RaceData race1, RaceData race2) 
    {
        return race1.getName().compareTo( race2.getName() );
    }

}
