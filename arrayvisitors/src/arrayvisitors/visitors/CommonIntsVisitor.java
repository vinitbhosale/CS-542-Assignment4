package arrayvisitors.visitors;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;

public class CommonIntsVisitor implements Visitor {
    private int[] inputArray;
    private int[] temp;
    private int counter = 0;

    @Override
    public void visit(MyArrayI inMyArrObj)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        if (counter == 0) {
            inputArray = ((MyArrayI) inMyArrObj).getArray();
            counter++;
        } else {
            temp = inputArray;
            inputArray = ((MyArrayI) inMyArrObj).getArray();

            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < inputArray.length; j++) {
                    if (temp[i] == inputArray[j]) {
                        System.out.println(temp[i]);
                        break;
                    }
                }
            }
        }

    }

    @Override
    public void visit(ArrayList<ElementI> inMyArrayListI)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        for (ElementI e : inMyArrayListI) {
            e.accept(this);
        }
    }

}