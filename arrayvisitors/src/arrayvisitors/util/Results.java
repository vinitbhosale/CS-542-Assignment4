package arrayvisitors.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import arrayvisitors.util.MyLogger;
/**
 * Results method that implemments FileDisplayInterface, StdoutDisplayInterface
 * and ResultsI interfaces. It stores results and implement writeToFile and
 * writeToStd method and prints in the output file.
 */
public class Results implements ResultsI, StdoutDisplayInterface, FileDisplayInterface {
    // Intializing filePath sting to store output file.
    private String filePath;
    // Initializing result string to store result
    private String result="";
    // Intializing file to create output file.
    private File outputFile;
    // Initializing BufferedWriter to write in output file.
    private BufferedWriter outputBufferedWriter;

    /**
     * Results constructor tha stores corresponding output file.
     * 
     * @param inFilePath - output file
     */
    public Results(String inFilePath){
        MyLogger.getInstnace().writeMessage("Results Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
        filePath = inFilePath;
    }
    /**
     * storeResult method to store results
     * 
     * @param inResString - result string
     */   
    @Override
    public void storeResult(String inResString) {
        // TODO Auto-generated method stub
        MyLogger.getInstnace().writeMessage("Storing results\n", MyLogger.DebugLevel.RESULTS);
        result = result.concat(inResString + "\n");
    }
    /**
     * writeToFile method that write results in the output file.
     * 
     * @throws IOException
     */
    @Override
    public void writeToFile() throws IOException {
        // TODO Auto-generated method stub
        MyLogger.getInstnace().writeMessage("Writing result to output file.", MyLogger.DebugLevel.RESULTS);
        outputFile = new File(filePath);
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }

        outputBufferedWriter = new BufferedWriter(new FileWriter(outputFile));

        outputBufferedWriter.write(result.trim());

        outputBufferedWriter.close();
    }
    /**
     * writeToStdout method to print result on stdout.
     */
    @Override
    public void writeToStdout() {
        // TODO Auto-generated method stub
        MyLogger.getInstnace().writeMessage("Writing result to Stdout.\n", MyLogger.DebugLevel.RESULTS);
        System.out.println(result);
    }

    @Override
    public String toString() {
        return "Class: Results, Data Members: [result=" + result.toString() + ", filePath=" + filePath.toString()
                + ", outputFile=" + outputFile.toString() + ", outputBufferedWriter=" + outputBufferedWriter.toString()
                + "]";
    }
   
    
}