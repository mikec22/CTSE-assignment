import java.util.*;
import Portfolio.Security;

public class DepositSecurityCommand extends UndoableCommand {
	
	private Security security;
	private int quantity;

	public DepositSecurityCommand(Security security, int quantity) {
		this.security = security;
		this.quantity = quantity;
	}

	public void execute() {
		security.setQuantity(security.getQuantity() + quantity);
		System.out.println("Deposit " + quantity + " from " + security.getCode()
					+ ". Current quantity is " + security.getQuantity());
	}
	
	protected Memento getMemento() {
		return null;
	}
	
	public void undo() {
		
	}
}