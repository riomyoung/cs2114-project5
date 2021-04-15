package covid;

public class RaceData {

    private String name;
    private int cases;
    private int deaths;
    private double cfRatio;
    
    public RaceData( String name, int cases, int deaths )
    {
        this.name = name;
        this.cases = cases;
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
    
    public int getDeaths()
    {
        return deaths;
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
