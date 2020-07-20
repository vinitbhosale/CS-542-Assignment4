package arrayvisitors.adt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;


import arrayvisitors.visitors.ElementI;
import arrayvisitors.visitors.Visitor;

public class MyArrayList implements MyArrayListI, ElementI {
    private ArrayList<ElementI> myArrayList = new ArrayList<>();

    @Override
    public void accept(Visitor visitor)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub
    //    for (ElementI e : myArrayList) {
    //        e.accept(visitor);
    //    }
        visitor.visit(myArrayList);
        
        
    }

    @Override
    public void insertMyArrayObj(ElementI inMyArrayObjList) {
        // TODO Auto-generated method stub
        myArrayList.add(inMyArrayObjList);
    }


}