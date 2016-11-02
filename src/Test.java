import Portfolio.*;
import java.util.*;

public class Test {
	public static void main(String[] args) {
		Vector<Security> list = new Vector();
		Security s = new StockV2("CB2", "adfadf", "HKX");
		Security b = new BondV2("qwe", "qwewqe", 4);
		list.add(s);
		list.add(b);
		Command com = new ShowSecurityCommand(new Vector(), "qwe");
		com.execute();
	}
}