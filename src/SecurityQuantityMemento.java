import Portfolio.Security;

/**
 * Created by Xuan on 3/11/2016.
 */
public class SecurityQuantityMemento implements Memento {
    private Security security;
    private int quantityState;

    public SecurityQuantityMemento(Security security) {
        this.security = security;
        quantityState = security.getQuantity();
    }

    @Override
    public void restore() {
        security.setQuantity(quantityState);
    }
}
