package prj5;

import java.util.Comparator;

/**
 *  Comparator for alphabetical order
 *
 * @author Rio Young  (riomyoung)
 * @version 2021.04.23
 */
public class CompareByAlpha implements Comparator<RaceData> {

    @Override
    public int compare(RaceData race1, RaceData race2) 
    {
        return race1.getName().compareTo( race2.getName() );
    }

}
