package ru.gb.family_tree.storage;

import java.io.Serializable;

public interface Storagable {
    boolean save(Serializable st, String path);

    Object load(String path);
}
