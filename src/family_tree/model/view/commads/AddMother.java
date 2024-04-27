package family_tree.model.view.commads;

import family_tree.model.view.ConsoleUI;

public class AddMother extends Command{
    public AddMother(ConsoleUI console) {
        super("Add mother", console);
    }

    public void execute() {
        getConsole().addMother();
    }

}
