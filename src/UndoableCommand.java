public abstract class UndoableCommand implements Command {
	private Memento memento;
	public abstract void execute();
	public abstract void undo();
	protected abstract Memento getMemento();
}