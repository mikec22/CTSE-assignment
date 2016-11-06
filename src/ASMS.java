import Portfolio.Security;

import java.util.AbstractList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class ASMS {

    private static AbstractList<Security> securities;
    private static Command com;
    private static CommandCreator commandCreator;
    private static Caretaker caretaker;
    private static Scanner kb;

    public static void main(String[] args) {
        securities = createList();
        caretaker = createCaretaker();
        kb = new Scanner(System.in);
        run();
    }

    private static void run() {
        try {
            while (true) {
                System.out.println("\n\nAdvanced Security Management System\n"
                        + "Please enter command: [n|s|d|w|u|r|l|q]\n"
                        + "n = create security, s = show security, d = deposit security, w = withdraw security,\n"
                        + "u = undo, r = redo, l = list undo/redo, q = exit system\n\n");
                String commandString = kb.nextLine();
                switch (commandString) {
                    case "n":
                        commandCreator = new CreateSecurityCommandCreator(securities);
                        break;
                    case "s":
                        commandCreator = new ShowSecurityCommandCreator(securities);
                        break;
                    case "d":
                        commandCreator = new DepositSecurityCommandCreator(securities);
                        break;
                    case "w":
                        commandCreator = new WithdrawSecurityCommandCreator(securities);
                        break;
                    case "u":
                        commandCreator = new UndoCommandCreator(caretaker);
                        break;
                    case "r":
                        commandCreator = new RedoCommandCreator(caretaker);
                        break;
                    case "l":
                        commandCreator = new ListCommandCreator(caretaker);
                        break;
                    case "q":
                        commandCreator = new ExitCommandCreator();
                        break;
                    default:
                        commandCreator = null;
                        com = null;
                        System.out.println("Command not found");
                        continue;
                }
                com = commandCreator.createCommand();
                com.execute();
                caretaker.addExecutedCommand(com);
                commandCreator = null;
                com = null;
            }
        } catch (InputMismatchException | NumberFormatException ex) {
            System.out.println("Input not expect.");
            //ex.printStackTrace();
            com = null;
            run();
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            //ex.printStackTrace();
            com = null;
            run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static AbstractList<Security> createList() {
        return new Vector();
    }

    private static Caretaker createCaretaker() {
        return new Caretaker();
    }
}