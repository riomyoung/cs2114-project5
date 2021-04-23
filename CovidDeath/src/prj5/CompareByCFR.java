package prj5;

import java.util.Comparator;

/**
 *  Comparator for increasing CFR
 *
 * @author Rio Young  (riomyoung)
 * @version 2021.04.23
 */
public class CompareByCFR implements Comparator<RaceData> {


    @Override
    public int compare(RaceData race1, RaceData race2) 
    {
        return (int) ( ( race1.getCFRatio() - race2.getCFRatio() ) * 100 );
    }

}
