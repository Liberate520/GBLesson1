package family_tree.model.view.commads;

import family_tree.model.view.ConsoleUI;

public class AddFather extends Command{
    public AddFather(ConsoleUI console) {
        super("Add Father", console);
    }

    public void execute() {
        getConsole().addFather();
    }
}
