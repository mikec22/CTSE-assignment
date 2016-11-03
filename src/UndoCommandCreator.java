/**
 * Created by Xuan on 3/11/2016.
 */
public class UndoCommandCreator extends CommandCreator {
    private Caretaker caretaker;

    public UndoCommandCreator(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    @Override
    public Command createCommand() {
        return new UndoCommand(caretaker.popUndoCommand());
    }
}
