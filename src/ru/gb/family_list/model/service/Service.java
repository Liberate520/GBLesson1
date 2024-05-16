package ru.gb.family_list.model.service;

import ru.gb.family_list.model.family.FamilyList;
import ru.gb.family_list.model.human.Human;
import ru.gb.family_list.writer.DocFileHandler;
import ru.gb.family_list.writer.FileHandler;
import ru.gb.family_list.writer.FileHandlerList;
import ru.gb.family_list.writer.SerializableFileHandler;

import java.io.IOException;
import java.util.GregorianCalendar;

public class Service {
    FamilyList<Human> fl;
    private FileHandlerList fhl;

    public Service() {
        this.fl = new FamilyList<>();
        this.fhl = new FileHandlerList();
    }

    public void addHuman(String name, String surname, GregorianCalendar dob, Human.Gender gender, Integer mother, Integer father) {
        Human hm = new Human(name, surname, dob, gender, fl.getHumanByIndex(mother), fl.getHumanByIndex(father));
        fl.addHuman(hm);
    }

    public String getFullList() {
        return fl.getFullList();
    }

    public void sortByAge() {
        fl.sortByAge();
    }

    public void sortByName() {
        fl.sortByName();
    }

    public void save(String path, Integer handler) {
        FileHandler fh = fhl.getFileHandlerByIndex(handler-1);
        fh.write(fl, path);
    }

    public void read(String path, Integer filetype) {
        FileHandler fh = fhl.getFileHandlerByIndex(filetype-1);
        fl = (FamilyList<Human>) fh.read(path);
        fl.getFullList();
    }

    public String getStringHandlers() {
        return fhl.getStringHandlers();
    }

    public String getAvailableFileTypes() {
        return fhl.getFileTypes();
    }
}
