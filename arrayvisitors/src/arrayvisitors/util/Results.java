package arrayvisitors.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements ResultsI, StdoutDisplayInterface, FileDisplayInterface {
    private String filePath;
    private String result="";
    private File outputFile;
    private BufferedWriter outputBufferedWriter;
 
    public Results(String inFilePath){
        filePath = inFilePath;
    }   
    @Override
    public void storeResult(String inResString) {
        // TODO Auto-generated method stub
        result = result.concat(inResString + "\n");
    }

    @Override
    public void writeToFile() throws IOException {
        // TODO Auto-generated method stub
        outputFile = new File(filePath);
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }

        outputBufferedWriter = new BufferedWriter(new FileWriter(outputFile));

        outputBufferedWriter.write(result.trim());

        outputBufferedWriter.close();
    }

    @Override
    public void writeToStdout() {
        // TODO Auto-generated method stub
        System.out.println(result);
    }

   
    
}