package behavioural.visitor.reflective;

/* this is called reflective visitor pattern as here we are going to use 'Reflection' to figure
    out exactly what kind of 'Expression' we have got in below 'ExpressionPrinter.print' method*/
abstract class Expression { }

class DoubleExpression extends Expression {
  public double value;

  public DoubleExpression(double value)
  {
    this.value = value;
  }
}

class AdditionExpression extends Expression {
  public Expression left, right;

  public AdditionExpression(Expression left, Expression right) {
    this.left = left;
    this.right = right;
  }
}

// separation of concerns
class ExpressionPrinter {
  public static void print(Expression e, StringBuilder sb) {
    // problems with reflective -
    //    1. below 'getClass' or 'instanceOf' makes the code slow as we are checking the class
    //    2. below also needs to make sure that all the cases and classes scenarios are covered as it is not enforced here
    if (e.getClass() == DoubleExpression.class) {
      sb.append(((DoubleExpression) e).value);
    } else if (e.getClass() == AdditionExpression.class) {
      AdditionExpression ae = (AdditionExpression)e;
      sb.append("(");
      print(ae.left, sb);
      sb.append("+");
      print(ae.right, sb);
      sb.append(")");
    }
  }
}

class ReflectiveVisitorDemo {
  public static void main(String[] args) {
    // 1+(2+3)
    AdditionExpression e = new AdditionExpression(
      new DoubleExpression(1),
      new AdditionExpression(
        new DoubleExpression(2),
        new DoubleExpression(3)
      ));
    StringBuilder sb = new StringBuilder();
    ExpressionPrinter.print(e, sb);
    System.out.println(sb);
  }
}
