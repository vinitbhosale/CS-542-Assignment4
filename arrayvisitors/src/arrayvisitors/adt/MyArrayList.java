package arrayvisitors.adt;

import java.util.ArrayList;

import arrayvisitors.visitors.ElementI;
import arrayvisitors.visitors.Visitor;

public class MyArrayList implements MyArrayListI, ElementI {
    private ArrayList<ElementI> myArrayList = new ArrayList<>();
    

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void insertMyArrayObj(ElementI inMyArrayObjList) {
        // TODO Auto-generated method stub
        myArrayList.add(inMyArrayObjList);
    }


}