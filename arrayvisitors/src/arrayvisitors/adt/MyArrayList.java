package arrayvisitors.adt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;

import arrayvisitors.visitors.ElementI;
import arrayvisitors.visitors.Visitor;

public class MyArrayList implements MyArrayListI {
    private ArrayList<ElementI> myArrayList = new ArrayList<>();

    @Override
    public void accept(Visitor visitor)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub

        visitor.visit(this);
    }

    @Override
    public void insertMyArrayObj(ElementI inMyArrayObjList) {
        // TODO Auto-generated method stub
        myArrayList.add(inMyArrayObjList);
    }

    @Override
    public ArrayList<ElementI> getMyArrayList() {
        // TODO Auto-generated method stub
        return myArrayList;
    }

}