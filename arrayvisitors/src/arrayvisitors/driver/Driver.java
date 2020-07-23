package arrayvisitors.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;

import arrayvisitors.UserException.SameFileNameException;
import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.Results;
import arrayvisitors.util.ResultsI;
import arrayvisitors.visitors.CommonIntsVisitor;
import arrayvisitors.visitors.ElementI;
import arrayvisitors.visitors.MissingIntsVisitor;
import arrayvisitors.visitors.PopulateMyArrayVisitor;
import arrayvisitors.visitors.SetI;
import arrayvisitors.visitors.Visitor;
import arrayvisitors.util.StdoutDisplayInterface;
import arrayvisitors.util.FileDisplayInterface;
import arrayvisitors.util.MyLogger;

/**
 * Driver class start point.
 * 
 * @author Vint S Bhosale
 */
public class Driver {
    public static void main(String[] args) throws InvalidPathException, FileNotFoundException, IOException,
            SameFileNameException {
        try {
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
            // Condition for missing input files
            if (args[0].isEmpty()) {
                throw new FileNotFoundException("Missing Input1 file parameter!");

            }
            if (args[1].isEmpty()) {
                throw new FileNotFoundException("Missing Input2 file parameter!");

            }
            // Condition to check same name of input and output files.
            if (args[0].equals(args[1]) || args[2].equals(args[3])) {
                throw new SameFileNameException("No two files can have same name!");
            }

            // Setting debug value in MyLogger.
            MyLogger.getInstnace().setDebugValue(Integer.parseInt(args[4]));
            MyLogger.getInstnace().writeMessage("Setting debug level to " + args[4], MyLogger.DebugLevel.DRIVER);

            // Intializing Arraylist for storing input files.
            ArrayList<String> fileList = new ArrayList<>();
            fileList.add(args[0]);
            fileList.add(args[1]);

            /**
             * Results objects of CommomIntsVisitor and
             * MissingIntsVisitor with output file as 
             * parameter respectively.
             */
            ResultsI commonIntRes = new Results(args[2]);
            ResultsI missingIntRes = new Results(args[3]);

            /**
             * Visitor objects.
             */
            Visitor populateMyArrayVisitor = new PopulateMyArrayVisitor();
            Visitor commonInstVisitor = new CommonIntsVisitor(commonIntRes);
            Visitor missingIntsVisitor = new MissingIntsVisitor(missingIntRes);

            // Initializing MyArrayList object.
            ElementI myArrayListIObj = new MyArrayList();

            MyLogger.getInstnace().writeMessage("Looping through each input file and populating array with integers.",
                    MyLogger.DebugLevel.DRIVER);
            
            
            //Looping through ArrayList of files.
            for (String inputFile : fileList) {
                // Setting input file.
                ((SetI) populateMyArrayVisitor).set(inputFile);
                // Creating MyArray element obj for input file.
                ElementI myArrayElement = new MyArray();
                MyLogger.getInstnace().writeMessage("Accepting populateMyArrayVisitor.", MyLogger.DebugLevel.DRIVER);
                // Element accepting populateMyArrayVisitor.
                myArrayElement.accept(populateMyArrayVisitor);
                // Inserting MyArray element obj to MyArrayList to store the object.
                ((MyArrayListI) myArrayListIObj).insertMyArrayObj(myArrayElement);
            }

            // MyArrayList element accepting CommonIntVisitor.
            MyLogger.getInstnace().writeMessage("Accepting CommonIntVisitor.", MyLogger.DebugLevel.DRIVER);
            myArrayListIObj.accept(commonInstVisitor);
            // MyArrayList element accepting MissingIntVisitor.
            MyLogger.getInstnace().writeMessage("Accepting missingIntsVisitor.", MyLogger.DebugLevel.DRIVER);
            myArrayListIObj.accept(missingIntsVisitor);


            MyLogger.getInstnace().writeMessage("Calling printResults to print results in Stdout.", MyLogger.DebugLevel.DRIVER);
            MyLogger.getInstnace().writeMessage("Calling printResultsToFile to print results in respective output file.\n",
                    MyLogger.DebugLevel.DRIVER);
            // Calling print method to display output on StdOut.
            printResults((StdoutDisplayInterface) commonIntRes, (StdoutDisplayInterface) missingIntRes);
             // Calling print method to print output in respective output files.
            printResultsToFile((FileDisplayInterface) commonIntRes, (FileDisplayInterface) missingIntRes);

        } catch (InvalidPathException | IOException | SameFileNameException e) {
            System.err.println(e.getMessage());
        } catch(NumberFormatException e){
            System.err.println("Invalid charachter in input file!");
        }

    }
    /**
     * printResults method to print result on StdOut
     * 
     * @param arr - StdoutDisplayInterface objects
     */
    private static void printResults(StdoutDisplayInterface... arr) {
        for (StdoutDisplayInterface result : arr) {
            result.writeToStdout();
        }
    }
    /**
     * printResultsToFile method to print output
     * in respective output file.
     * 
     * @param arr - FileDisplayInterface objects.
     * @throws IOException
     */
    private static void printResultsToFile(FileDisplayInterface... arr) throws IOException {
        for (FileDisplayInterface result : arr) {
            result.writeToFile();
        }
    }
}