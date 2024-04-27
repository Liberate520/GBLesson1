package family_tree.model.view.commads;

import family_tree.model.view.ConsoleUI;

public class AddHuman extends Command{
    public AddHuman(ConsoleUI console) {
        super("Add human to family tree", console);
    }

    public void execute() {
        getConsole().addHuman();
    }
}
