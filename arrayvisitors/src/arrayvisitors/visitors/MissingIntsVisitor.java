package arrayvisitors.visitors;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;

public class MissingIntsVisitor implements Visitor {
    private ArrayList<ElementI> myArrayObjList = new ArrayList<>();
    private int[] inputArray1;
    private int[] inputArray2;
    private int[] temp;
    private int counter = 0;
    private int limit = 100;

    @Override
    public void visit(MyArrayI inMyArrObj)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        if (counter == 0) {
            inputArray1 = inMyArrObj.getArray();
            findMissingInts(inputArray1, 1);
            counter++;
        }else{
            inputArray2 = inMyArrObj.getArray();
            findMissingInts(inputArray2, 2);
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

    public void findMissingInts(int[] inputArray, int k) {
        temp = new int[limit];
        for (int i : inputArray1) {
            if (i < 100) {
                temp[i] = 1;
            }
        }
        System.out.println("Missing in input"+ k+":");
        int j = 0;
        while (j < limit) {
            if (temp[j] == 0) {
                System.out.println(j);
            } else {
                j++;
            }
            j++;
        }
    }
}