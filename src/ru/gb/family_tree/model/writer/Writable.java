package ru.gb.family_tree.model.writer;

import java.io.Serializable;

public interface Writable {
    void save(Serializable serializable) ;
    Object load ();

}
