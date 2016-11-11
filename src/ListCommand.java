import java.util.AbstractList;

/**
 * Created by Xuan on 3/11/2016.
 */
public class ListCommand implements Command {
    private AbstractList<UndoableCommand> undoList, redoList;

    public ListCommand(AbstractList<UndoableCommand> undoList, AbstractList<UndoableCommand> redoList) {
        this.redoList = redoList;
        this.undoList = undoList;
    }

    @Override
    public void execute() {
        System.out.println("Undo List:");
        if (!undoList.isEmpty()) {
            for (UndoableCommand command : undoList) {
                System.out.println(command);
            }
        } else {
            System.out.println("Empty");
        }
        System.out.println("\n\nRedo List:");
        if (!redoList.isEmpty()) {
            for (UndoableCommand command : redoList) {
                System.out.println(command);
            }
        } else {
            System.out.println("Empty");
        }
    }
}
