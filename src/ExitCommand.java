/**
 * Created by Xuan on 3/11/2016.
 */
public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("\nLeaving System...\n");
        System.exit(0);
    }
}
