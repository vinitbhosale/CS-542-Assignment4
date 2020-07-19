package arrayvisitors.visitors;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

public interface ElementI {
    public void accept(Visitor visitor)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException;

}