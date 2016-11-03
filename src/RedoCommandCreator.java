/**
 * Created by Xuan on 3/11/2016.
 */
public class RedoCommandCreator extends CommandCreator {
    private Caretaker caretaker;

    public RedoCommandCreator(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    @Override
    public Command createCommand() {
        return new RedoCommand(caretaker.popRedoCommand());
    }
}
