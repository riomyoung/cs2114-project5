package prj5;

public class RaceData {

    private String name;
    private int cases;
    private int deaths;
    private double cfRatio;
    
    public RaceData( String name, int cases, int deaths )
    {
        this.name = name;
        if ( cases == 0 )
        {
            cases = 1;
        }
        else
        {
            this.cases = cases;
        }
        this.deaths = deaths;
        cfRatio = ( deaths / cases ) * 100;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getCases()
    {
        return cases;
    }
    
    public void setCases( int newCases )
    {
        if ( newCases != 0 )
        {
            cases = newCases;
            cfRatio = ( deaths / cases ) * 100;
        }
    }
    
    public int getDeaths()
    {
        return deaths;
    }
    
    public void setDeaths( int newDeaths )
    {
        deaths = newDeaths;
        cfRatio = ( deaths / cases ) * 100;
    }
    
    public double getCFRatio()
    {
        return cfRatio;
    }
    
    public String toString()
    {
        return name + ": " + cases + " cases, " + cfRatio + "% CFR";
    }
}
