import java.util.Stack;

/**
 * Created by Mike on 2/11/2016.
 */
public class Caretaker {

    private Stack<UndoableCommand> undoList, redoList;

    public Caretaker() {
        undoList = new Stack();
        redoList = new Stack();
    }

    public void addExecutedCommand(Command executedCommand) {
        if (executedCommand instanceof UndoableCommand) {
            if (((UndoableCommand) executedCommand).isExecuted()) {
                undoList.push((UndoableCommand) executedCommand);
                redoList.clear();
            }
        }
    }

    public UndoableCommand popUndoCommand() {
        if (!undoList.empty()) {
            redoList.push(undoList.peek());
            return undoList.pop();
        } else {
            throw new NullPointerException("No Action to be undo");
        }
    }

    public UndoableCommand popRedoCommand() {
        if (!redoList.empty()) {
            undoList.push(redoList.peek());
            return redoList.pop();
        } else {
            throw new NullPointerException("No Action to be redo");
        }
    }

    public Stack<UndoableCommand> getUndoList() {
        return undoList;
    }

    public Stack<UndoableCommand> getRedoList() {
        return redoList;
    }
}
