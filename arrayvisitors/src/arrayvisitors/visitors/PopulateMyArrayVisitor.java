package arrayvisitors.visitors;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.FileProcessor;

public class PopulateMyArrayVisitor implements Visitor, SetI {

    private String filePath;
    private String strData;
    private int integerValue;
    private int LIMIT = 100;

    public PopulateMyArrayVisitor() {
    }

    @Override
    public void visit(MyArrayI inMyArrObj)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub

        readInput(inMyArrObj);

    }

    @Override
    public void visit(MyArrayListI inMyArrListObj)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public void set(String inFile) {

        // TODO Auto-generated method stub
        filePath = inFile;
    }

    public void readInput(MyArrayI inMyArrObj)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

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
        //inMyArrObj.print();
        fp.close();

    }

}