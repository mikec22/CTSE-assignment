/**
 * Created by Xuan on 3/11/2016.
 */
public class UndoCommand implements Command {
    private UndoableCommand command;

    public UndoCommand(UndoableCommand command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.undo();
        System.out.println("undo completed.");
    }
}
