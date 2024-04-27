package family_tree.model.view.commads;

import family_tree.model.view.ConsoleUI;

public class FindHumanByID extends Command {
    public FindHumanByID(ConsoleUI console) {
        super("Find human by ID", console);
    }

    public void execute() {
        getConsole().findHumanByID();
    }
}
