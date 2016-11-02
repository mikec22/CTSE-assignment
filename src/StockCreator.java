import Portfolio.*;
import java.util.Scanner;

public class StockCreator extends SecurityCreator {

	public Security createSecurity() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter code, name and exchange:");
		String code = kb.nextLine();
		String name = kb.nextLine();
		String exchange = kb.nextLine();
		return new StockV2(code, name, exchange);
	}
}