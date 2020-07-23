package arrayvisitors.visitors;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.MyLogger;

public class PopulateMyArrayVisitor implements Visitor, SetI {

    private String filePath;
    private String strData;
    private int integerValue;

    public PopulateMyArrayVisitor() {
        MyLogger.getInstnace().writeMessage("PopulateMyArrayVisitor Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
    }
    /**
     * visit method that visit elements.
     * 
     * @param inMyArrObj - MyArray obj element
     */
    @Override
    public void visit(MyArrayI inMyArrObj)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        MyLogger.getInstnace().writeMessage("PopulateMyArrayVisitor visit method.", MyLogger.DebugLevel.POPULATEMYARRAYVISITOR);
        readInput(inMyArrObj);

    }   
    /**
     * visit method that visit elements in MyArrayList obj.
     * 
     * @param inMyArrListObj - MyArrayList obj
     */
    @Override
    public void visit(MyArrayListI inMyArrListObj)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub

    }
    /**
     * set method that set input file.
     * 
     * @param inFile - input file
     */
    @Override
    public void set(String inFile) {

        // TODO Auto-generated method stub
        filePath = inFile;
    }
    /**
     * readInput method read integer from input
     * file and calls storeIntegers method to store 
     * the integer into an array.
     * 
     * @param inMyArrObj - MyArray obj. 
     */
    public void readInput(MyArrayI inMyArrObj)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        
        MyLogger.getInstnace().writeMessage("PopulateMyArrayVisitor reading input file", MyLogger.DebugLevel.POPULATEMYARRAYVISITOR);
        FileProcessor fp = new FileProcessor(filePath);
        strData = fp.poll();
        if (null == strData) {
            System.err.println("Empty Input file!");
        }
        while (strData != null) {
            if (strData.length() == 0) {
                System.err.println("Empty line in input file!");
            }
            integerValue = Integer.parseInt(strData);
            if (integerValue >=0 && integerValue < 100) {
                inMyArrObj.storeIntegers(integerValue);

                strData = fp.poll();
            }else{
                strData = fp.poll();
            }

        }
        fp.close();

    }

    @Override
    public String toString() {
        return "Class: PopulateMyArrayVisitor, Data Members: [filePath=" + filePath.toString() + "strData=" + strData.toString() + 
        "integerValue]";

    }

}