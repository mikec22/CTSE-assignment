import Portfolio.Security;

import java.util.AbstractList;

public class CreateSecurityCommand extends UndoableCommand {

    private AbstractList<Security> securities;
    private Security security;

    public CreateSecurityCommand(AbstractList<Security> securities, Security security) {
        this.securities = securities;
        this.security = security;
    }

    @Override
    public void execute() {
        for (Security s : securities) {
            if (security.getCode().equals(s.getCode())) {
                System.out.println("Security already existed");
                return;
            }
        }
        securities.add(security);
        System.out.println("New security record created.");
        executed = true;
        memento = createMemento();
    }

    @Override
    public void undo() {
        memento.restore();
    }

    @Override
    protected Memento createMemento() {
        return new SecuritiesMemento(securities);
    }

    @Override
    public String toString() {
        return "Create " + security.getCode();
    }
}