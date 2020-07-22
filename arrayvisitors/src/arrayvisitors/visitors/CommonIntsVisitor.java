package arrayvisitors.visitors;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.ResultsI;

public class CommonIntsVisitor implements Visitor {
    private int[] inputArray;
    private int[] temp;
    private int index1;
    private int index2;
    private int counter = 0;
    private ArrayList<ElementI> myArrayObjList = new ArrayList<>();
    private ResultsI res;

    public CommonIntsVisitor(ResultsI inRes) {
        res = inRes;
    }

    @Override
    public void visit(MyArrayI inMyArrObj)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        if (counter == 0) {
            inputArray = inMyArrObj.getArray();
            index1 = inMyArrObj.getIndex();
            counter++;
        } else {
            temp = inputArray;
            inputArray = inMyArrObj.getArray();
            index2 = inMyArrObj.getIndex();
            res.storeResult("Commom integers in both arrays:");
            for (int i = 0; i < index1; i++) {
                for (int j = 0; j < index2; j++) {
                    if (temp[i] == inputArray[j]) {
                        res.storeResult(Integer.toString(temp[i]));
                        break;
                    }
                }
            }
        }

    }

    @Override
    public void visit(MyArrayListI inMyArrListObj)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        myArrayObjList = inMyArrListObj.getMyArrayList();
        for (ElementI myArrayElement : myArrayObjList) {
            myArrayElement.accept(this);
        }
    }

}