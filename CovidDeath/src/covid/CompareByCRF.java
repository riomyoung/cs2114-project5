package covid;

import java.util.Comparator;

public class CompareByCRF implements Comparator<RaceData> {


    @Override
    public int compare(RaceData race1, RaceData race2) 
    {
        return (int) ( ( race1.getCFRatio() - race2.getCFRatio() ) * 100 );
    }

}
