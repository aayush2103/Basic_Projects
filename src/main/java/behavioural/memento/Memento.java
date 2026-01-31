package behavioural.memento;

/*  Memento - a token/handle representing the system state. Lets us roll back to the state when the
      token was generated. May or may not directly expose state information.
*
      1. mementos are used to roll back states arbitrarily
      2. a memento is simply a token/handle class with (typically) no functions of its own
      3. a memento is not required to expose directly the state(s) to which it reverts the system
      4. can be used to implement undo/redo
* */
class Memento {
  public int balance;

  public Memento(int balance)
  {
    this.balance = balance;
  }
}

class BankAccount {
  private int balance;

  public BankAccount(int balance)
  {
    this.balance = balance;
  }

  public Memento deposit(int amount) {
    balance += amount;
    return new Memento(balance);
  }

  public void restore(Memento m)
  {
    balance = m.balance;
  }

  @Override
  public String toString() {
    return "BankAccount{" +
      "balance=" + balance +
      '}';
  }
}

class MementoDemo {
  public static void main(String[] args) {
    BankAccount ba = new BankAccount(100);
    Memento m1 = ba.deposit(50); // 150
    Memento m2 = ba.deposit(25); // 175
    System.out.println(ba);

    // restore to m1
    ba.restore(m1);
    System.out.println(ba);

    // restore to m2
    ba.restore(m2);
    System.out.println(ba);
  }
}