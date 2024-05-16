package ru.gb.family_list.writer;

import ru.gb.family_list.model.family.FamilyList;
import ru.gb.family_list.model.family.Stringable;
import ru.gb.family_list.model.human.Human;

import java.io.IOException;
import java.io.Serializable;

public class DocFileHandler<E extends Stringable> extends FileHandler<E> {

    private String filetype;

    public DocFileHandler() {
        this.filetype = "doc";
    }

    @Override
    public void write(E o, String path) {
        StringBuilder sb = new StringBuilder();
        sb.append("Это док файл хэндиер, записал в файл инфу\n");
        sb.append(o.getStringedData());
        System.out.println(sb);
    }

    @Override
    public E read(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append("Это док файл хэндиер, прочитал инфу и собрал обратно объект FamilyList\n");
        System.out.println(sb);
        FamilyList fl = new FamilyList<>();
        return (E) fl;
    }
}
