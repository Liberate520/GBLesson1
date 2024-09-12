package ru.gb.family_tree.writer;

import java.io.Serializable;

public interface Writer {
    boolean saveFile(Serializable serializable);
    Object readFile();
}
