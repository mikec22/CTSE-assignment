import java.util.*;
import Portfolio.Security;

public class WithdrawSecurityCommand extends UndoableCommand {
	
	private Security security;
	private int quantity;

	public WithdrawSecurityCommand(Security security, int quantity) {
		this.security = security;
		this.quantity = quantity;
	}

	public void execute() {
		security.setQuantity(security.getQuantity() - quantity);
	}
	
	protected Memento getMemento() {
		return null;
	}
	
	public void undo() {
		
	}
}