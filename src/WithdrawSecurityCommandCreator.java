import Portfolio.Security;

import java.util.AbstractList;
import java.util.Scanner;

public class WithdrawSecurityCommandCreator extends CommandCreator {

    private AbstractList<Security> securities;

    public WithdrawSecurityCommandCreator(AbstractList securities) {
        this.securities = securities;
    }

    public Command createCommand() {
        Scanner kb = new Scanner(System.in);
        Security security = null;
        boolean isFound = false;
        System.out.println("Enter code:");
        String code = kb.nextLine();
        for (Security s : securities) {
            if (s.getCode().equals(code)) {
                security = s;
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            throw new RuntimeException("Security Not Found!");
        }
        System.out.println("Quantity to withdraw:");
        int quantity = kb.nextInt();
        if ((security.getQuantity() - quantity) < 0)
            throw new RuntimeException("Invalid quantity (Current quantity < withdrawal quantity).");
        return new WithdrawSecurityCommand(security, quantity);
    }
}