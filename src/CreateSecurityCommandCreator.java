import Portfolio.Security;

import java.util.AbstractList;
import java.util.Scanner;

public class CreateSecurityCommandCreator extends CommandCreator {

    private AbstractList<Security> securities;

    public CreateSecurityCommandCreator(AbstractList<Security> securities) {
        this.securities = securities;
    }

    @Override
    public Command createCommand() {
        System.out.println("Enter security type(bo=bond/st=stock):");
        Scanner kb = new Scanner(System.in);
        String type = kb.nextLine();
        return new CreateSecurityCommand(securities, type);
    }
}