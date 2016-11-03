import Portfolio.Security;

import java.util.AbstractList;

public class ShowSecurityCommand implements Command {

    private AbstractList<Security> securities;
    private String securityCode;

    public ShowSecurityCommand(AbstractList<Security> securities, String securityCode) {
        this.securities = securities;
        this.securityCode = securityCode;
    }

    public void execute() {
        if (!securities.isEmpty()) {
            System.out.println("Security information");
            if (securityCode.equals("##")) {
                System.out.printf("%-15s %-30s %-15s %-20s%n", "Code", "Name", "Quantity", "OtherInfo");
                for (Security security : securities) {
                    System.out.printf("%-15s %-30s %-15s %-20s%n",
                            security.getCode(), security.getName(), security.getQuantity(), security);
                }
            } else {
                for (Security security : securities) {
                    if (security.getCode().equals(securityCode)) {
                        System.out.println("Code: " + security.getCode()
                                + "\nName: " + security.getName()
                                + "\nQuantity: " + security.getQuantity()
                                + "\n" + security.toString());
                    }
                }
            }
        } else {
            System.out.println("No Security Created!");
        }
    }
}