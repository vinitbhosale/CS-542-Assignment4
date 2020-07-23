package arrayvisitors.visitors;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.ResultsI;
import arrayvisitors.util.MyLogger;

public class MissingIntsVisitor implements Visitor {
    private ArrayList<ElementI> myArrayObjList = new ArrayList<>();
    private int[] inputArray1;
    private int[] inputArray2;
    private int index;
    private int[] temp;
    private int counter = 0;
    private int limit = 100;
    private ResultsI res;
    private MyLogger mg;

    public MissingIntsVisitor(ResultsI inRes) {
        res = inRes;
        MyLogger.getInstnace().writeMessage("CommonIntsVisitor Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
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
        MyLogger.getInstnace().writeMessage("MissingIntsVisitor visiting array.", MyLogger.DebugLevel.MISSINGINTSVISITOR);
        if (counter == 0) {
            inputArray1 = inMyArrObj.getArray();
            index = inMyArrObj.getIndex();
            findMissingInts(inputArray1,index, 1);
            counter++;
        } else {
            inputArray2 = inMyArrObj.getArray();
            index = inMyArrObj.getIndex();
            findMissingInts(inputArray2,index, 2);
        }

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
        MyLogger.getInstnace().writeMessage("MissingIntsVisitor visiting MyArrayList.", MyLogger.DebugLevel.MISSINGINTSVISITOR);
        // Fetching ArrayList of MyArray. 
        myArrayObjList = inMyArrListObj.getMyArrayList();
        // Looping each element of ArrayList anf visiting with visitor.
        for (ElementI myArrayElement : myArrayObjList) {
            myArrayElement.accept(this);
        }
    }
    /**
     * findMissingInts method finds missing integers in an array.
     * 
     * @param inputArray - integer array
     * @param index - number of integer in an array
     * @param k - number of input file
     */
    public void findMissingInts(int[] inputArray,int index, int k) {
        MyLogger.getInstnace().writeMessage("MissingIntsVisitor finding missing integer in array.", MyLogger.DebugLevel.MISSINGINTSVISITOR);
        temp = new int[limit];
        for (int i = 0; i < limit; i++) {
            temp[i] = 0;
        }
        for (int i=0; i < index; i++) {
            if(i<limit){
                temp[inputArray[i]] = 1;
            }
        }
        res.storeResult("Missing in input" + k + ":");
        int j = 0;
        while (j < limit) {
            if (temp[j] == 0) {
                res.storeResult(String.format("%02d", j));
            }
            j++;
        }
    }
}