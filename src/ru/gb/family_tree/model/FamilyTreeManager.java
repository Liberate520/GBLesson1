package ru.gb.family_tree.model;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.save.Writable;

public class FamilyTreeManager {
    private final Writable writable;


    // Внедрение зависимости через конструктор
    public FamilyTreeManager(Writable writable) {
        this.writable = writable;
    }

    // Метод для загрузки FamilyTree из файла
    public FamilyTree load(String filePath) {
        return (FamilyTree) writable.read(filePath);
    }

    // Метод для сохранения FamilyTree в файл
    public void save(FamilyTree familyTree, String filePath) {
        writable.save(familyTree, filePath);
    }
}

