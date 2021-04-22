package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Parses through file containing 
 *      states, races and covid statistics 
 *
 * @author Rio Young  (riomyoung)
 * @version 2021.04.21
 */
public class FileParser {
    
    private LinkedList<State> states;
    
    /**
     * New FileParser object.
     * 
     *@param fileName
     *      name of file
     *      
     */
    public FileParser( String fileName ) throws FileNotFoundException
    {
        states = new LinkedList<State>(); 
        File file = new File( fileName );
        Scanner scanner = new Scanner( file );

        String[] header = scanner.next().split(",");
        String current = header[1];
        int index = 1;
        LinkedList<String> raceNames = new LinkedList<String>();
        
        while ( current.contains("Cases_"))
        {
            raceNames.add(current.substring(6).toLowerCase());
//            System.out.println( current.substring(6).toLowerCase() );
            index++;
            current = header[ index ];
        }
        
        while ( scanner.hasNext() )
        {
            String[] currentLine = scanner.next().split(",");
            for ( int i = 0; i < currentLine.length; i++ )
            {
//                System.out.print( currentLine[i] + "   ");
            }
//            System.out.println( "" );
            
            State newState = new State( currentLine[0] );
            
            for ( int i = 0; i < raceNames.size(); i++ )
            {
//                System.out.print( currentLine[i] + "   ");
                int cases, deaths;
                try 
                {
                    cases = Integer.parseInt(currentLine[ i + 1 ]);
                }
                catch ( NumberFormatException nfe )
                {
                    cases = -1;
                }
                
                try 
                {
                    deaths = Integer.parseInt(
                        currentLine[ i + 1 + raceNames.size() ]);
                }
                catch ( NumberFormatException nfe )
                {
                    deaths = -1;
                }
                
                RaceData newRace = new RaceData( 
                    raceNames.getEntry(i), cases, deaths);
                newState.addRace(newRace);
//                System.out.println( newRace.toString() );
//                System.out.println( newRace.getDeaths() );
            }
            
            states.add(newState);
        }
        
        for ( int i = 0; i < states.size(); i++ )
        {
            State currentState = states.getEntry(i);
            System.out.println( currentState.getName() );
            //SORT ALPHA
            printRaces( currentState );
            //SORT CFRATIO
            printRaces( currentState );
            
        }
        
    }
    
    
    /**
     * Returns LinkedList of State objects
     * 
     *@return states
     */
    public LinkedList<State> getStates()
    {
        return states;
    }
    
    /**
     * Prints states and races in certain order
     * 
     */
    private void printRaces( State currentState )
    {
        for ( int j = 0; j < currentState.getRaces().size(); j++ )
        {
            System.out.println( currentState.getRaces().getEntry(j).toString());
        }
        
        System.out.println("=====");
    }
    

}
