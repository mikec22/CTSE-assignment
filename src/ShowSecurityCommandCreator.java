import Portfolio.Security;

import java.util.AbstractList;
import java.util.Scanner;

public class ShowSecurityCommandCreator extends CommandCreator {

    private AbstractList<Security> securities;

    public ShowSecurityCommandCreator(AbstractList<Security> securities) {
        this.securities = securities;
    }

    @Override
    public Command createCommand() {
        if (!securities.isEmpty()) {
            System.out.println("Enter code(## to show all):");
            Scanner kb = new Scanner(System.in);
            String code = kb.nextLine();
            return new ShowSecurityCommand(securities, code);
        } else {
            throw new RuntimeException("No Security Created!");
        }
    }
}