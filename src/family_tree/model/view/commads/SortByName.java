package family_tree.model.view.commads;

import family_tree.model.view.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI console) {
        super("Sort by name", console);
    }

    public void execute() {
        getConsole().sortByName();
    }
}
