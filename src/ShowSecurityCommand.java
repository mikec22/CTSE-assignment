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
            if (securityCode.equals("##")) {
                System.out.println("Security information");
                System.out.printf("%-15s %-30s %-15s %-20s%n", "Code", "Name", "Quantity", "OtherInfo");
                for (Security security : securities) {
                    System.out.printf("%-15s %-30s %-15s %-20s%n",
                            security.getCode(), security.getName(), security.getQuantity(), security);
                }
            } else {
                Security security = null;
                for (Security s : securities) {
                    if (s.getCode().equals(securityCode)) {
                        security = s;
                        break;
                    }
                }
                if (security != null) {
                    System.out.println("Security information");
                    System.out.println("Code: " + security.getCode()
                            + "\nName: " + security.getName()
                            + "\nQuantity: " + security.getQuantity()
                            + "\n" + security);
                } else {
                    System.out.println("Security not found");
                }
            }
        } else {
            System.out.println("No Security Created!");
        }
    }
}