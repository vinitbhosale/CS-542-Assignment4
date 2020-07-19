package arrayvisitors.visitors;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;

public class MissingIntsVisitor implements Visitor {


    @Override
    public void visit(MyArrayI inMyArrObj)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public void visit(MyArrayListI inMyArrayListI) {
        // TODO Auto-generated method stub

    }

}