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

    //this method for adding executed command
    public void addExecutedCommand(Command executedCommand) {
        if (executedCommand instanceof UndoableCommand) {
            if (((UndoableCommand) executedCommand).isExecuted()) {
                undoList.push((UndoableCommand) executedCommand);
                // when a command added the redoList must clear
                redoList.clear();
            }
        }
    }

    public UndoableCommand popUndoCommand() {
        if (!undoList.empty()) {
            //undo command at the same time push the command to redo.
            redoList.push(undoList.peek());
            return undoList.pop();
        } else {
            throw new NullPointerException("No Action to be undone");
        }
    }

    public UndoableCommand popRedoCommand() {
        if (!redoList.empty()) {
            //redo command at the same time push the command to undo.
            undoList.push(redoList.peek());
            return redoList.pop();
        } else {
            throw new NullPointerException("No Action to be redone");
        }
    }

    public Stack<UndoableCommand> getUndoList() {
        return undoList;
    }

    public Stack<UndoableCommand> getRedoList() {
        return redoList;
    }
}
