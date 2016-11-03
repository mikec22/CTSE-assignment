import Portfolio.Bond;

/**
 * This class is for providing show security(Other Info) function.
 * Throught override toString() method.
 **/

public class BondV2 extends Bond {

    public BondV2(String code, String name, float yield) {
        super(code, name, yield);
    }

    @Override
    public String toString() {
        return "Yield: " + super.getYield();
    }
}