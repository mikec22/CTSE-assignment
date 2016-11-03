import java.util.AbstractList;

/**
 * Created by Xuan on 3/11/2016.
 */
public class ListCommand implements Command {
    private AbstractList<UndoableCommand> redo, undo;

    public ListCommand(AbstractList<UndoableCommand> undo, AbstractList<UndoableCommand> redo) {
        this.redo = redo;
        this.undo = undo;
    }

    @Override
    public void execute() {
        System.out.println("Undo List:");
        if (!undo.isEmpty()) {
            for (UndoableCommand command : undo) {
                System.out.println(command);
            }
        } else {
            System.out.println("Empty");
        }
        System.out.println("\n\nRedo List:");
        if (!redo.isEmpty()) {
            for (UndoableCommand command : redo) {
                System.out.println(command);
            }
        } else {
            System.out.println("Empty");
        }
    }
}
