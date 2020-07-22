package arrayvisitors.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;

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
        ArrayList<String> fileList = new ArrayList<>();
        fileList.add(args[0]);
        fileList.add(args[1]);

        ResultsI commonIntRes = new Results(args[2]);
        ResultsI missingIntRes = new Results(args[3]);

        Visitor populateMyArrayVisitor = new PopulateMyArrayVisitor();
        Visitor commonInstVisitor = new CommonIntsVisitor(commonIntRes);
        Visitor missingIntsVisitor = new MissingIntsVisitor(missingIntRes);
        
        ElementI myArrayListIObj = new MyArrayList();
//Done
        for (String inputFile : fileList) {
            ((SetI) populateMyArrayVisitor).set(inputFile);
            ElementI myArrayElement = new MyArray();
            myArrayElement.accept(populateMyArrayVisitor);
            ((MyArrayListI) myArrayListIObj).insertMyArrayObj(myArrayElement);
        }


        myArrayListIObj.accept(commonInstVisitor);
        myArrayListIObj.accept(missingIntsVisitor);

        ((StdoutDisplayInterface) commonIntRes).writeToStdout();
        ((StdoutDisplayInterface) missingIntRes).writeToStdout();

        ((FileDisplayInterface) commonIntRes).writeToFile();
        ((FileDisplayInterface) missingIntRes).writeToFile();

    }
}