import Portfolio.*;
import java.util.Scanner;

public class StockCreator extends SecurityCreator {

	public Security createSecurity() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter code, name and exchange:");
		String input = kb.nextLine();
		String code;
		String name;
		String exchange;
		String[] result = input.split(",");
		if (result.length == 3) {
			code = result[0];
			name = spaceFilter(result[1]);
			exchange = spaceFilter(result[2]);
		} else {
			throw new RuntimeException("Input not expect!");
		}
		return new StockV2(code, name, exchange);
	}
}