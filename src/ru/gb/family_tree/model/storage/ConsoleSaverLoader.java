package ru.gb.family_tree.model.storage;

import java.io.Serializable;

public class ConsoleSaverLoader implements Storagable{
    @Override
    public boolean save(Serializable sr, String path) {
        FileHolder fh = new FileHolder();
        return fh.save(sr, path);
    }

    @Override
    public Object load(String path) {
        FileHolder fh = new FileHolder();
        Object tree = fh.load(path);
        return tree;
    }
}
