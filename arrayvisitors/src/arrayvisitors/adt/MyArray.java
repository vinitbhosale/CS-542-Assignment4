package arrayvisitors.adt;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
//import java.util.Stack;

import arrayvisitors.visitors.ElementI;
import arrayvisitors.visitors.Visitor;

public class MyArray implements MyArrayI, ElementI {

    private int inputArray[];
    private int index;
    //private Stack<Integer> stack;

    public MyArray() {
        inputArray = new int[10];
        index = 0;
        //stack = new Stack<>();
    }

    @Override
    public void storeIntegers(int inValue) {
        // TODO Auto-generated method stub
        if (inputArray.length == index) {
            increaseArraySize();
        }
        inputArray[index] = inValue;
        index++;
        // stack.push(inValue);
        // Arrays.sort(inputArray);

    }

    @Override
    public void increaseArraySize() {
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

    public void print() {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println(inputArray[i]);
        }
    }

    @Override
    public void accept(Visitor visitor)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }

}