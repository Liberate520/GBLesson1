package family_tree.model.view.commads;

import family_tree.model.view.ConsoleUI;

public class SaveFile extends Command{
    public SaveFile(ConsoleUI console) {
        super("Save file", console);
    }

    @Override
    public void execute() {
        getConsole().saveFile();
    }
}
