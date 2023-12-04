package ru.gb.family_tree.writer;

import java.io.FileNotFoundException;
import java.io.Serializable;

public interface Writable {
    void save(Serializable serializable) ;
    void load (Serializable serializable);

}
