package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

public class CovidWindow {

    private Window window;
    private Button quitButton;
    private Button[] representButtons;
    private Button sortCFR;
    private Button sortAlpha;
    private Shape[] raceBars;
    private TextShape title;
    private LinkedList<State> states;
    private State currentState;
    private final double barHeight = 20.0;
    private final double barWidth = 20.0;
    
    public CovidWindow( WindowBackEnd backEnd )
    {
        window = new Window();
        
        sortAlpha = new Button( "Sort By Alpha" );
        sortAlpha.onClick(this, "clickedSortAlpha");
        window.addButton(sortAlpha, WindowSide.NORTH);
        
        quitButton = new Button( "Quit" );
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);
        
        sortCFR = new Button( "Sort By CFR" );
        sortCFR.onClick(this, "clickedSortCFR");
        window.addButton(sortCFR, WindowSide.NORTH);
        
        states = backEnd.getList();
        createStateButtons();
        
        currentState = states.getEntry(0);
        createRaceShapes();
        updateTitle( currentState.getName() );
            
    }
    
    private void createStateButtons()
    {
        for ( int i = 0; i < states.size(); i++ )
        {
            Button newButton = new 
                Button("Represent " + states.getEntry(i).getName() );
            newButton.onClick(this, 
                "clicked" + states.getEntry(i).getName() );
            window.addButton(newButton, WindowSide.SOUTH);
        }
    }
    
    private void updateTitle( String name )
    {
        TextShape title = new TextShape(0, 0,
            name + " Case Fatality Ratios by Race" );
        int x = (window.getGraphPanelWidth() / 2) - (title.getWidth()
            / 2);
        int y = 20;
        title.moveTo(x, y);
        
        window.addShape(title);
    }
    
    private void createRaceShapes()
    {
        LinkedList<RaceData> races = currentState.getRaces();
        int barSpacing = window.getGraphPanelWidth() / ( races.size() + 1 );
        int windowHeight = window.getGraphPanelHeight();
        int bottomSpacing = 50;
        
        for ( int i = 0; i < races.size(); i++ )
        {
            int x = (int)(barSpacing + i * barSpacing - ( barWidth / 2));
            int height = (int)(barHeight * ( races.getEntry(i).getCFRatio() ));
            
            Shape newShape = new Shape(
                x, 
                windowHeight - height - bottomSpacing,
                (int) barWidth, 
                (int) height, 
                Color.blue );
            races.getEntry(i);
            
            window.addShape(newShape);
            
            TextShape race = new TextShape( 
                x - (int) barWidth / 2,
                windowHeight - bottomSpacing,
                races.getEntry(i).getName());
            window.addShape(race);
            
            TextShape CFR = new TextShape( 
                x - (int) barWidth / 2,
                windowHeight - bottomSpacing + race.getHeight(),
                races.getEntry(i).getCFRatio() + "%");
            window.addShape(CFR);
        }
    }
    public void clickedRepState( Button button )
    {
        
    }
    public void clickedSortAlpha( Button button )
    {
        CompareByAlpha compA = new CompareByAlpha();
        states.sort( compA );
    }
    public void clickedSortCFR( Button button )
    {
        CompareByCFR compCFR = new CompareByCFR();
        states.sort( compCFR );
        createRaceShapes();
    }
    public void clickedQuit( Button button )
    {
        System.exit( 0 );
    }
    
    public void clickedDC( Button button )
    {
        
    }
    public void clickedGA( Button button )
    {
        
    }
    public void clickedMD( Button button )
    {
        
    }
    public void clickedNC( Button button )
    {
        
    }
    public void clickedTN( Button button )
    {
        
    }
    public void clickedVA( Button button )
    {
        
    }
    
}
