import java.util.*;

public class CreateSecurityCommand extends UndoableCommand {
	
	private AbstractList securities;
	private String type;

	public CreateSecurityCommand(AbstractList securities,String type) {
		this.securities = securities;
		this.type = type;
	}

	public void execute() {
		SecurityCreator sc;
		if (type.equals("bo")){
			sc = new BondCreator();
		} else if (type.equals("st")) {
			sc = new StockCreator();
		} else {
			System.out.println("Type not found");
			return;
		}
		securities.add(sc.createSecurity());
		System.out.println("New security record created.");
	}
	
	public void undo() {
		
	}
	
	protected Memento getMemento() {
		return null;
	}
}