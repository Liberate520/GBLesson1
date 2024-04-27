package family_tree.model.view.commads;

import family_tree.model.view.ConsoleUI;

public class LoadFile extends Command{
    public LoadFile(ConsoleUI console) {
        super("Load file", console);
    }

    @Override
    public void execute() {
        getConsole().loadFile();
    }
}
