import Portfolio.Security;

import java.util.AbstractList;

public class CreateSecurityCommand extends UndoableCommand {

    private AbstractList<Security> securities;
    private Security security;
    private String type;

    public CreateSecurityCommand(AbstractList<Security> securities, String type) {
        this.securities = securities;
        this.type = type;
    }

    @Override
    public void execute() {
        SecurityCreator sc;
        if (type.equals("bo")) {
            sc = new BondCreator();
        } else if (type.equals("st")) {
            sc = new StockCreator();
        } else {
            System.out.println("Type not found");
            return;
        }
        security = sc.createSecurity();
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