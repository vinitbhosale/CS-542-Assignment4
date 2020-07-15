package arrayvisitors.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

/**
 * Driver class start point.
 * 
 * @author Vint S Bhosale
 */
public class Driver {
    public static void main(String[] args) throws InvalidPathException, FileNotFoundException, IOException {

        /*
         * As the build.xml specifies the arguments as input1, input2,commonintsout,
         * missingintsout and debug value, in case the argument value is not given java
         * takes the default value specified in build.xml. To avoid that, below
         * condition is used
         */
        if ((args.length != 5) || (args[0].equals("${input1}")) || (args[1].equals("${input2}"))
                || (args[2].equals("${commonintsout}")) || (args[3].equals("${missingintsout}"))
                || (args[4].equals("${debug}"))) {
            System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
            System.exit(0);
        }
        System.out.println("Hello World! Lets get started with the assignment");
    }
}