package family_tree.model.view.commads;

import family_tree.model.view.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI console) {
        super("Sort by age", console);
    }

    public void execute() {
        getConsole().sortByAge();
    }
}
