package ru.gb.family_tree.model.storage;

import java.io.Serializable;

public interface Storagable {
    boolean save(Serializable sr, String path);

    Object load(String path);
}
