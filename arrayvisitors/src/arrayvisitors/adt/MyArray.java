package arrayvisitors.adt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import arrayvisitors.util.MyLogger;
import arrayvisitors.visitors.Visitor;

/**
 * MyArray Class implements Array creation for input 
 * file and storing integers into those arrays.
 */
public class MyArray implements MyArrayI {

    private int inputArray[];
    private int index;

        
    /**
     * MyArray constructor that initialize an array
     * and its index, also set array capacity to 10. 
     */
    public MyArray() {
        MyLogger.getInstnace().writeMessage("MyArray Constrructor", MyLogger.DebugLevel.CONSTRUCTOR);
        inputArray = new int[10];
        index = 0;
    }

    /**
     * accept method that accept visitor for MyArray class.
     * 
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        MyLogger.getInstnace().writeMessage("MyArray accept method.", MyLogger.DebugLevel.MYARRAY);
        //mg.writeMessage("MyArray accept method.", MyLogger.DebugLevel.MYARRAY);
        visitor.visit(this);
    }
    /**
     * getArray method 
     * 
     * @return inputArray
     */
    @Override
    public int[] getArray() {
        // TODO Auto-generated method stub
        return inputArray;
    }
    /**
     * storeIntegers method that stores integer value
     * in array.
     * 
     * @param inValuse - integer
     */
    @Override
    public void storeIntegers(int inValue) {
        // TODO Auto-generated method stub
        MyLogger.getInstnace().writeMessage("Storing integer in array in MyArray Class.", MyLogger.DebugLevel.MYARRAY);
        // Condition to check whether to increase tha size of array.
        if (inputArray.length == index) {
            increaseArraySize();
        }
        inputArray[index] = inValue;
        index++;

    }
    /**
     * increaseArraySize method implements
     * increase of array size by 50%.
     */
    @Override
    public void increaseArraySize() {
        MyLogger.getInstnace().writeMessage("Increasing size of the array.", MyLogger.DebugLevel.MYARRAY);
        // TODO Auto-generated method stub
        int[] temp = new int[index];
        for (int i = 0; i < inputArray.length; i++) {
            temp[i] = inputArray[i];
        }
        inputArray = null;
        inputArray = new int[index + (index / 2)];
        for (int j = 0; j < temp.length; j++) {
            inputArray[j] = temp[j];
        }

    }

    /**
     * getIndex method that return the number 
     * of ints in the array.
     * 
     * @return index
     */
    @Override
    public int getIndex() {
        // TODO Auto-generated method stub
        return index;
    }

   

}