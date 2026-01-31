package behavioural.command;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
* Command - an object which represents an instruction to perform a particular action.
*   Contains all the information necessary for the action to be taken.
*
*   1. encapsulate all details of an operation in a separate object
*   2. define instruction for applying the command (either in the command itself, or elsewhere)
*   3. optionally define instructions for undoing the command
*   4. can create composite commands (a.k.a. macros)
* */
class BankAccount {
    private int balance;
    private int overdraftAmount = -500;

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount +
                ", balance is now " + balance);
    }

    public boolean withdraw(int amount) {
        if (balance - amount >= overdraftAmount) {
            balance -= amount;
            System.out.println("Withdrew " + amount +
                    ", balance is now " + balance);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankAccount{ balance = " + balance + " }";
    }
}

interface Command {
    void call();
    void undo();
}

class BankAccountCommand implements Command {
    private BankAccount account;
    private boolean succeeded;

    public enum Action {
        DEPOSIT, WITHDRAW
    }
    private Action action;
    private int amount;

    public BankAccountCommand(BankAccount account, Action action, int amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }

    @Override
    public void call() {
        switch(action) {
            case DEPOSIT:
                succeeded = true;
                account.deposit(amount);
                break;
            case WITHDRAW:
                succeeded = account.withdraw(amount);
                break;
        }
    }

    @Override
    public void undo() {
        if (!succeeded) return;
        switch(action) {
            case DEPOSIT:
                account.withdraw(amount);
                break;
            case WITHDRAW:
                account.deposit(amount);
                break;
        }
    }
}

public class CommandDemo {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        System.out.println(ba);

        List<BankAccountCommand> commands = List.of(
           new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100),
           new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000)
        ) ;

        for (BankAccountCommand c : commands) {
            c.call();
        }

        // for undo operations for the command
        Collections.reverse(commands);
        for (Command c : commands) {
            c.undo();
            System.out.println(ba);
        }
    }
}
