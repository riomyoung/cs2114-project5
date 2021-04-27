package prj5;

import java.awt.Color;
import java.util.Random;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
/**
 * Creates a window Covid statistics
 *
 * @author Rio Young  riomyoung
 * @version 2021.04.26
 */
public class CovidWindow {

    private Window window;
    private Button quitButton;
    private Button[] representButtons;
    private Button sortCFR;
    private Button sortAlpha;
    private Shape[] raceBars;
    private TextShape[] raceNames;
    private TextShape[] raceCFR;
    private TextShape title;
    private LinkedList<State> states;
    private State currentState;
    private final double barHeight = 20.0;
    private final double barWidth = 20.0;
    
    /**
     * Creates new CovidWindow object
     *
     * @param backEnd
     *      backEnd containing relevant information
     * 
     */
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
        representButtons = new Button[ states.size() ];
        createStateButtons();
        
        currentState = states.getEntry(0);
        raceBars = null;
        raceNames = null;
        raceCFR = null;
        createRaceShapes();
        updateTitle();
            
    }
    
    /**
     * Creates buttons for each state
     *
     */
    private void createStateButtons()
    {
        for ( int i = 0; i < states.size(); i++ )
        {
            Button newButton = new 
                Button("Represent " + states.getEntry(i).getName() );
            newButton.onClick(this, "clickedRepState" );
            representButtons[i] = new Button();
            window.addButton(newButton, WindowSide.SOUTH);
        }
    }
    
    /**
     * Updates the title
     *
     * @param name
     *      name of state
     */
    private void updateTitle()
    {
        String name = currentState.getName();
        title = new TextShape(0, 0,
            name + " Case Fatality Ratios by Race" );
        int x = (window.getGraphPanelWidth() / 2) - (title.getWidth()
            / 2);
        int y = 20;
        title.moveTo(x, y);
        
        window.addShape(title);
    }
    
    /**
     * Creates bar graph representing the data
     *
     */
    private void createRaceShapes()
    {
        LinkedList<RaceData> races = currentState.getRaces();
        int barSpacing = window.getGraphPanelWidth() / ( races.size() + 1 );
        int windowHeight = window.getGraphPanelHeight();
        int bottomSpacing = 50;
        window.removeAllShapes();

        //If no shapes already added to 
        if ( raceBars == null )
        {
            raceBars = new Shape[ races.size()];
            raceNames = new TextShape[ races.size()];
            raceCFR = new TextShape[ races.size()];
            for ( int i = 0; i < races.size(); i++ )
            {
                raceBars[i] = new Shape(0, 0);
                raceNames[i] = new TextShape(0, 0, null);
                raceCFR[i] = new TextShape(0, 0, null);
            }
        }
        
        //Updating states
        for ( int i = 0; i < races.size(); i++ )
        {
            int x = (int)(barSpacing + i * barSpacing - ( barWidth / 2));
            int height = (int)(barHeight * ( races.getEntry(i).getCFRatio() ));
            
            raceBars[i] = new Shape(
                x, 
                windowHeight - height - bottomSpacing,
                (int) barWidth, 
                (int) height, 
                Color.blue );
            races.getEntry(i);
            
            window.addShape( raceBars[i] );
            
            raceNames[i] = new TextShape( 
                x - (int) barWidth / 2,
                windowHeight - bottomSpacing,
                races.getEntry(i).getName());
            window.addShape(raceNames[i]);
            
            raceCFR[i] = new TextShape( 
                x - (int) barWidth / 2,
                windowHeight - bottomSpacing + raceNames[i].getHeight(),
                races.getEntry(i).getCFRatio() + "%");
            window.addShape(raceCFR[i]);
        }
    }
    
    /**
     * Changes currently viewed state
     *
     */
    public void clickedRepState( Button button )
    {
    //TODO: Random int is for testing
    //Need to check which button is pressed and 
        //update currentState
        //call createRaceShapes()
        //call updateTitle
        Random rand = new Random();
        int random = rand.nextInt(6);
        currentState = states.getEntry(random);
        createRaceShapes();
        updateTitle();
    }
    
    /**
     * Sorts data by alphabetical order
     *
     * @param button
     *      button being pressed
     */
    public void clickedSortAlpha( Button button )
    {
        CompareByAlpha compA = new CompareByAlpha();
        states.sort( compA );
        createRaceShapes();
    }
    
    /**
     * Sorts data by CFRatio
     *
     * @param button
     *      button being pressed
     */
    public void clickedSortCFR( Button button )
    {
        CompareByCFR compCFR = new CompareByCFR();
        states.sort( compCFR );
        createRaceShapes();
    }
    
    /**
     * Quits application
     *
     * @param button
     *      button being pressed
     */
    public void clickedQuit( Button button )
    {
        System.exit( 0 );
    }
    
   
    
}
