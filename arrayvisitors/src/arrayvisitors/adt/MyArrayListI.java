package arrayvisitors.adt;

import java.util.ArrayList;

import arrayvisitors.visitors.ElementI;

public interface MyArrayListI extends ElementI {
    public void insertMyArrayObj(ElementI inMyArrayObjList);

    public ArrayList<ElementI> getMyArrayList();
}