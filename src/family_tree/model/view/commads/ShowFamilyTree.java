package family_tree.model.view.commads;

import family_tree.model.view.ConsoleUI;

public class ShowFamilyTree extends Command {
    public ShowFamilyTree(ConsoleUI console) {
        super("Show family tree", console);
    }

    public void execute() {
        getConsole().showFamilyTree();
    }
}
