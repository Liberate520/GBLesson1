package family_tree.model.writer;

import java.io.*;

public interface Writable {
    void writeFamilyTree(Serializable serializable, String filePath) throws IOException;
    Serializable readFamilyTree(String filePath) throws IOException, ClassNotFoundException;
}
