/**
 * Created by Xuan on 3/11/2016.
 */
public class ListCommandCreator extends CommandCreator {
    private Caretaker caretaker;

    public ListCommandCreator(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    @Override
    public Command createCommand() {
        return new ListCommand(caretaker.getUndoList(), caretaker.getRedoList());
    }
}
