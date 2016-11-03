public abstract class UndoableCommand implements Command {
    protected Memento memento;
    protected boolean executed;

    public UndoableCommand() {
        executed = false;
    }

    public abstract void execute();

    public abstract void undo();

    protected abstract Memento createMemento();

    public boolean isExecuted() {
        return executed;
    }
}