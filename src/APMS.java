import java.util.*;
import Portfolio.Security;

public class APMS {

	private static AbstractList<Security> securites;
	private static Command com;
	private static CommandCreator commandCreator;
	private static Stack<Command> undoList, redoList;
	private static Scanner kb;

	public static void main(String[] args) {
		securites = new Vector();
		kb = new Scanner(System.in);
		run();
	}

	private static void run() {
		try{
			while (true) {
				System.out.println("\n\nAdvanced Security Management System\n" 
					+ "Please enter command: [n|s|d|w|c|r|l|q]\n"
					+ "n = create security, s = show security, d = deposit security, w = withdraw security,\n"
					+ "u = undo, r = redo, l = list undo/redo, q = exit system\n\n");
				String commandString = kb.nextLine();
				if (commandString.equals("n")) {
					commandCreator = new CreateSecurityCommandCreator(securites);
				} else if (commandString.equals("s")) {
					commandCreator = new ShowSecurityCommandCreator(securites);
				} else if (commandString.equals("d")) {
					commandCreator = new DepositSecurityCommandCreator(securites);
				} else if (commandString.equals("w")) {
					commandCreator = new WithdrawSecurityCommandCreator(securites);
				} else if (commandString.equals("q")) {
					System.exit(0);
				}
				com = commandCreator.createCommand();
				com.execute();
				com = null;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			com = null;
			run();
		}
	}
}