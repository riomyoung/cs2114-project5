package prj5;

import java.text.DecimalFormat;

/**
 * RaceData Object contains name of race, 
 *  number of Covid cases, 
 *  number of Covid deaths, and
 *  Case Fatality Ratio (CFR)
 *
 * @author Rio Young  (riomyoung)
 * @version 2021.04.21
 */
public class RaceData {

    private String name;
    private int cases;
    private int deaths;
    private double cfRatio;
    
    /**
     * New RaceData object.
     * 
     *@param name
     *      the name of the race
     *@param cases
     *      the numbers of Covid cases
     *@param deaths
     *      the numbers of Covid deaths
     *      
     */
    public RaceData( String name, int cases, int deaths )
    {
        this.name = name;
        if ( cases == 0 )
        {
            this.cases = 1;
        }
        else
        {
            this.cases = cases;
        }
        this.deaths = deaths;
        updateCFRatio();
    }
    
    /**
     * Returns name of race
     * 
     *@return name
     *      
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns number of Covid cases
     * 
     *@return cases
     *      
     */
    public int getCases()
    {
        return cases;
    }
    
    /**
     * Sets number of Covid cases
     * 
     *@param newCases
     *      new number of cases
     *      
     */
    public void setCases( int newCases )
    {
        if ( newCases != 0 )
        {
            cases = newCases;
            updateCFRatio();
        }
    }
    
    /**
     * Returns number of Covid deaths
     * 
     *@return deaths
     *      
     */
    public int getDeaths()
    {
        return deaths;
    }
    
    /**
     * Sets number of Covid deaths
     * 
     *@param newDeaths
     *      new number of deaths
     *      
     */
    public void setDeaths( int newDeaths )
    {
        deaths = newDeaths;
        updateCFRatio();
    }
    
    /**
     * Returns the Case Fatality Ratio
     * 
     *@return cfRatio
     *      
     */
    public double getCFRatio()
    {
        return cfRatio;
    }
    
    /**
     * Updates the CFRatio and checks if cases or deaths are -1
     * 
     */
    private void updateCFRatio()
    {
        if ( cases == -1 || deaths == -1 )
        {
            cfRatio = -1;
        }
        else
        {
            cfRatio = ( (double) deaths / (double) cases ) * 100;
            cfRatio = Double.parseDouble(
                new DecimalFormat("##.#").format(cfRatio));

        }
    }
    
    /**
     * Returns String version of race
     * 
     *@return String
     *      new number of cases
     *      
     */
    public String toString()
    {
        return name + ": " + cases + " cases, " + cfRatio + "% CFR";
    }
    
    
}
