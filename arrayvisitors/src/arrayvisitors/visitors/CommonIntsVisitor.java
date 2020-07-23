package arrayvisitors.visitors;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.ResultsI;
import arrayvisitors.util.MyLogger;

/**
 * CommonIntsVisitor method implements visits method
 * and find common integers between two arrays and
 * store the result.
 */
public class CommonIntsVisitor implements Visitor {
    private int[] inputArray;
    private int[] temp;
    private int index1;
    private int index2;
    private int counter = 0;
    private ArrayList<ElementI> myArrayObjList = new ArrayList<>();
    private ResultsI res;
    private MyLogger mg;

    /**
     * CommonIntsVisitor Constructor.
     * 
     * @param inRes - Results obj.
     */
    public CommonIntsVisitor(ResultsI inRes) {
        MyLogger.getInstnace().writeMessage("CommonIntsVisitor Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
        res = inRes;
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
        MyLogger.getInstnace().writeMessage("CommonIntsVisitor Visiting array.", MyLogger.DebugLevel.COMMONINTSVISITOR);
        // Condition to store first and second array.
        if (counter == 0) {
            inputArray = inMyArrObj.getArray();
            index1 = inMyArrObj.getIndex();
            counter++;
        } else {
            temp = inputArray;
            inputArray = inMyArrObj.getArray();
            index2 = inMyArrObj.getIndex();
            res.storeResult("Commom integers in both arrays:");
            // Looping to find common integers between two arrays.
            for (int i = 0; i < index1; i++) {
                for (int j = 0; j < index2; j++) {
                    if (temp[i] == inputArray[j]) {
                        res.storeResult(String.format("%02d", temp[i]));
                        break;
                    }
                }
            }
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
        MyLogger.getInstnace().writeMessage("CommonIntsVisitor Visiting MyArrayList.", MyLogger.DebugLevel.COMMONINTSVISITOR);
        // Fetching ArrayList of MyArray. 
        myArrayObjList = inMyArrListObj.getMyArrayList();
        // Looping each element of ArrayList anf visiting with visitor.
        for (ElementI myArrayElement : myArrayObjList) {
            myArrayElement.accept(this);
        }
    }

}