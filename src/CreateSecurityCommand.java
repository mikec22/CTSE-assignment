import Portfolio.Security;

import java.util.AbstractList;

public class CreateSecurityCommand extends UndoableCommand {

    private AbstractList<Security> securities;
    private Security security;
    private boolean added;

    public CreateSecurityCommand(AbstractList<Security> securities, Security security) {
        this.securities = securities;
        this.security = security;
        added = false;
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
        added = true;
        executed = true;
    }

    @Override
    public void undo() {
        if (added) {
            securities.remove(security);
            added = false;
        } else {
            securities.add(security);
            added = true;
        }
    }

    @Override
    protected Memento createMemento() {
        return null;
    }

    @Override
    public String toString() {
        return "Create " + security.getCode();
    }
}