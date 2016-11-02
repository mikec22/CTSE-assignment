import java.util.*;

public class ShowSecurityCommandCreator extends CommandCreator {

	private AbstractList list;

	public ShowSecurityCommandCreator(AbstractList list) {
		this.list = list;
	}

	public Command createCommand() {
		if (!list.isEmpty()){
			System.out.println("Enter code(## to show all):");
			Scanner kb = new Scanner(System.in);
			String code = kb.nextLine();
			return new ShowSecurityCommand(list, code);
		} else {
			throw new RuntimeException("No Security Created!");
		}
	}
}