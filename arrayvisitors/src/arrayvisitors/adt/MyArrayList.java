package arrayvisitors.adt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;

import arrayvisitors.util.MyLogger;
import arrayvisitors.visitors.ElementI;
import arrayvisitors.visitors.Visitor;

/**
 * MyArrayList class implements ArrayList creation of 
 * Element type and store MyArray elemnts in the list
 * Also it accept visitors.
 */
public class MyArrayList implements MyArrayListI {
    // Intializing ArrayList of Element type to store MyArray obj.
    private ArrayList<ElementI> myArrayList = new ArrayList<>();
    

    public MyArrayList(){
        MyLogger.getInstnace().writeMessage("MyArrayList Constructor.", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    /**
     * Accept method that accept visitiors for MyArrayLisy class.
     * 
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        MyLogger.getInstnace().writeMessage("MyArrayList accept method accepting visitor.", MyLogger.DebugLevel.MYARRAYLIST);
        visitor.visit(this);
    }
    /**
     * insertMyArrayObj method insert MyArray obj into ArrayList.
     * 
     * @param inMyArrayObjList
     */
    @Override
    public void insertMyArrayObj(ElementI inMyArrayObjList) {
        // TODO Auto-generated method stub
        MyLogger.getInstnace().writeMessage("Inserting MyArray objects in ArrayList of MyArrayList.", MyLogger.DebugLevel.MYARRAYLIST);
        myArrayList.add(inMyArrayObjList);
    }
    /**
     * getMyArrayList method that return ArryList of MyArray objs.
     * 
     * @return myArrayList
     */
    @Override
    public ArrayList<ElementI> getMyArrayList() {
        // TODO Auto-generated method stub
        return myArrayList;
    }
    @Override
    public String toString() {
    return "Class: MyArrayList, Data Members: [myArrayList=" + myArrayList.toString() + "]";
    }

}