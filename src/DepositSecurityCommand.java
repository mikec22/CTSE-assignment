import Portfolio.Security;

public class DepositSecurityCommand extends UndoableCommand {

    private Security security;
    private int quantity;

    public DepositSecurityCommand(Security security, int quantity) {
        this.security = security;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        memento = createMemento();
        security.setQuantity(security.getQuantity() + quantity);
        System.out.println("Deposit " + quantity + " to " + security.getCode()
                + ". Current quantity is " + security.getQuantity());
        executed = true;
    }

    @Override
    public void undo() {
        Memento temp = createMemento();
        memento.restore();
        memento = temp;
    }

    @Override
    protected Memento createMemento() {
        return new SecurityQuantityMemento(security);
    }

    @Override
    public String toString() {
        return "Deposit " + quantity + " " + security.getCode();
    }
}