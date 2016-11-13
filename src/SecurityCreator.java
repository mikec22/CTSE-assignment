import Portfolio.Security;
//AbstractFactory
public abstract class SecurityCreator {
    public abstract Security createSecurity();

    protected String spaceFilter(String s) {
        if (s.charAt(0) == ' ') {
            s = s.replaceFirst(" ", "");
            return spaceFilter(s);
        } else {
            return s;
        }
    }
}