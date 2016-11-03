/**
 * Created by Xuan on 3/11/2016.
 */
public class RedoCommand implements Command {
    private UndoableCommand command;

    public RedoCommand(UndoableCommand command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.undo();
        System.out.println("redo completed.");
    }
}
