import java.util.*;

public class CreateSecurityCommandCreator extends CommandCreator {

	private AbstractList list;

	public CreateSecurityCommandCreator(AbstractList list) {
		this.list = list;
	}

	public Command createCommand() {
		System.out.println("Enter security type(bo=bond/st=stock):");
		Scanner kb = new Scanner(System.in);
		String type = kb.nextLine();
		return new CreateSecurityCommand(list, type);
	}
}