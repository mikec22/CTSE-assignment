import Portfolio.Security;

import java.util.Scanner;
//ConcreteFactory
public class BondCreator extends SecurityCreator {
    @Override
    public Security createSecurity() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter code, name and yield:");
        String input = kb.nextLine();
        String code;
        String name;
        float yield;
        String[] result = input.split(",");
        // the result format must equals 3
        if (result.length == 3) {
            code = result[0];
            name = spaceFilter(result[1]);
            yield = Float.parseFloat(result[2]);
        } else {
            throw new RuntimeException("Input not expect!");
        }
        return new BondV2(code, name, yield);
    }
}