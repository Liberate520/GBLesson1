package ru.gb.family_list.writer;

import java.io.IOException;
import java.io.Serializable;

public interface Writable<E> {
    public void write(E o, String path);
    public E read(String path);
}
