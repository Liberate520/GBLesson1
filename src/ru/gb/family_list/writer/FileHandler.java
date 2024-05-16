package ru.gb.family_list.writer;

public abstract class FileHandler<E> implements Writable<E>{
    private String filetype;

    public String getFiletype() {
        return filetype;
    }
}
