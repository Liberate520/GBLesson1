package family_tree.model.view.commads;

import family_tree.model.view.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super("Finish work", consoleUI);
    }

    @Override
    public void execute() {
        getConsole().finish();
    }
}
