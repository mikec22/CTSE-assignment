import Portfolio.Security;

public class WithdrawSecurityCommand extends UndoableCommand {

    private Security security;
    private int quantity;

    public WithdrawSecurityCommand(Security security, int quantity) {
        this.security = security;
        this.quantity = quantity;
    }

    public void execute() {
        memento = createMemento();
        security.setQuantity(security.getQuantity() - quantity);
        System.out.println("Deposit " + quantity + " from " + security.getCode()
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
        return "Withdraw " + quantity + security.getCode();
    }
}