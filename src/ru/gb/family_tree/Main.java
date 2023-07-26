package ru.gb.family_tree;

import ru.gb.family_tree.model.tree_elements.Item;
import ru.gb.family_tree.service.handler.FileHandler;
import ru.gb.family_tree.service.tree_service.TreeService;
import ru.gb.family_tree.viewer.BaseTerminal;

public class Main {
    public static void main(String[] args) {

        BaseTerminal<TreeService<Item>> bt = new BaseTerminal<>(new FileHandler("data.txt"));
        bt.start();
    }
}
