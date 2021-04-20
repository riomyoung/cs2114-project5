package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {
    
    private LinkedList<State> states;
    
    public FileParser( String filename ) throws FileNotFoundException
    {
        states = new LinkedList<State>(); 
        File file = new File( filename );
        Scanner scanner = new Scanner( file );

        
        while ( scanner.hasNext() )
        {
            System.out.println( scanner.next() );
        }
        
    }
    
    public LinkedList<State> getStates()
    {
        return states;
    }
    

}
