package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class GetHumansInfo extends Command {
    public GetHumansInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список семьи";
    }

    public void execute(){
        consoleUI.getHumansListInfo();
    }
}
