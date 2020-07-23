package arrayvisitors.adt;

import arrayvisitors.visitors.ElementI;

public interface MyArrayI extends ElementI{
    public void storeIntegers(int inValue);
    public void increaseArraySize();
    public int[] getArray();
    public int getIndex();

}