package ru.gb.family_list.writer;

import java.util.ArrayList;
import java.util.List;

public class FileHandlerList {

    private List<FileHandler> fileHandlerList;

    public FileHandlerList() {
        fileHandlerList = new ArrayList<>();
        fileHandlerList.add(new DocFileHandler());
        fileHandlerList.add(new SerializableFileHandler());
    }

    public String getStringHandlers(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fileHandlerList.size(); i++) {
            sb.append(i+1 + ": ");
            sb.append(fileHandlerList.get(i).getClass().getSimpleName());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getFileTypes(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fileHandlerList.size(); i++) {
            sb.append(i+1 + ": ");
            sb.append(fileHandlerList.get(i).getFiletype());
            sb.append("\n");
        }
        return sb.toString();
    }

    public FileHandler getFileHandlerByIndex(Integer index) {
        return fileHandlerList.get(index);
    }
}
