import Portfolio.Security;

import java.util.AbstractList;

/**
 * Created by Xuan on 3/11/2016.
 */
public class SecuritiesMemento implements Memento {
    private AbstractList<Security> securities;
    private Security security;
    private boolean added;

    public SecuritiesMemento(AbstractList<Security> securities) {
        this.securities = securities;
        security = securities.get(securities.size() - 1);
        added = true;
    }

    @Override
    public void restore() {
        if (added) {
            securities.remove(securities.indexOf(security));
            added = false;
        } else {
            securities.add(security);
            added = true;
        }
    }
}
