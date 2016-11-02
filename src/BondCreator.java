import Portfolio.*;
import java.util.Scanner;

public class BondCreator extends SecurityCreator {

	public Security createSecurity() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter code, name and yield:");
		String code = kb.nextLine();
		String name = kb.nextLine();
		float yield = kb.nextFloat();
		return new BondV2(code, name, yield);
	}
}