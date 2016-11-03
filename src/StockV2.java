import Portfolio.Stock;

/**
 * This class is for providing show security(Other Info) function.
 * Throught override toString() method.
 **/

public class StockV2 extends Stock {

    public StockV2(String code, String name, String exchange) {
        super(code, name, exchange);
    }

    @Override
    public String toString() {
        return "Exchange: " + super.getExchange();
    }
}