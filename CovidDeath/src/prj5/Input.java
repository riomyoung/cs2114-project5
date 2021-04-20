package prj5;

import java.io.FileNotFoundException;

public class Input {

    public static void main(String[] args) throws FileNotFoundException {

        FileParser parser;
        
        if ( args.length == 0 )
        {
            parser = new 
                FileParser( "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
        else
        {
            parser = new FileParser( args[0] );
        }
        
        WindowBackEnd backEnd = new WindowBackEnd( parser.getStates() );
    }

}
