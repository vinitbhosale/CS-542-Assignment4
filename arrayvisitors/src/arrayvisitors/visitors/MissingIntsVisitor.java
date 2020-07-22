package arrayvisitors.visitors;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.ResultsI;

public class MissingIntsVisitor implements Visitor {
    private ArrayList<ElementI> myArrayObjList = new ArrayList<>();
    private int[] inputArray1;
    private int[] inputArray2;
    private int index;
    private int[] temp;
    private int counter = 0;
    private int limit = 100;
    private ResultsI res;

    public MissingIntsVisitor(ResultsI inRes) {
        res = inRes;
    }

    @Override
    public void visit(MyArrayI inMyArrObj)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub
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

    @Override
    public void visit(MyArrayListI inMyArrListObj)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        myArrayObjList = inMyArrListObj.getMyArrayList();
        for (ElementI myArrayElement : myArrayObjList) {
            myArrayElement.accept(this);
        }
    }

    public void findMissingInts(int[] inputArray,int index, int k) {
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
                res.storeResult(Integer.toString(j));
            }
            j++;
        }
    }
}