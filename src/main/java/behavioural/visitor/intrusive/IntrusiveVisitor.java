package behavioural.visitor.intrusive;

/* by Intrusive Visitor we mean that we are going to jump into classes we have already written
    and already tested maybe and we are going to modify the entire hierarchy*/
abstract class Expression {
  /* by introducing below method we are breaking 2 laws :
  *   1. Open Close principle - by changing existing classes
  *   2. SRP - because printing is a separate concern, so this should be put in a
  *       separate hierarchy in a separate class*/
  public abstract void print(StringBuilder sb);
}

class DoubleExpression extends Expression {
  private double value;

  public DoubleExpression(double value) {
    this.value = value;
  }

  @Override
  public void print(StringBuilder sb) {
    sb.append(value);
  }
}

class AdditionExpression extends Expression {
  private Expression left, right;

  public AdditionExpression(Expression left, Expression right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public void print(StringBuilder sb) {
    sb.append("(");
    left.print(sb);
    sb.append("+");
    right.print(sb);
    sb.append(")");
  }
}

class IntrusiveVisitorDemo {
  public static void main(String[] args) {
    // 1+(2+3)
    AdditionExpression e = new AdditionExpression(
      new DoubleExpression(1),
      new AdditionExpression(
        new DoubleExpression(2),
        new DoubleExpression(3)
      ));
    StringBuilder sb = new StringBuilder();
    e.print(sb);
    System.out.println(sb);
  }
}
