/**
 * Created by Xuan on 3/11/2016.
 */
public class ExitCommandCreator extends CommandCreator {
    @Override
    public Command createCommand() {
        return new ExitCommand();
    }
}
