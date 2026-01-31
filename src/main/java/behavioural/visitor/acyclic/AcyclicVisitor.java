package behavioural.visitor.acyclic;

/* Visitor - a pattern where a component (visitor) is allowed to traverse the entire inheritance
*    hierarchy. Implemented by propagating a single 'visit()' method throughout the entire hierarchy.
*
*     1. propagate an 'accept(Visitor v)' method throughout the entire hierarchy
*     2. create a visitor with 'visit(Foo)', 'visit(Bar)', ... for each element in the hierarchy
*     3. each 'accept()' simply calls 'visitor.visit(this)'
*     4. acyclic visitor allows greater flexibility at a cost to performance */
interface Visitor {}

interface ExpressionVisitor extends Visitor {
  void visit(Expression obj);
}

interface DoubleExpressionVisitor extends Visitor {
  void visit(DoubleExpression obj);
}

interface AdditionExpressionVisitor extends Visitor {
  void visit(AdditionExpression obj);
}

abstract class Expression {
  // optional
  public void accept(Visitor visitor) {
    if (visitor instanceof ExpressionVisitor) {
      ((ExpressionVisitor) visitor).visit(this);
    }
  }
}

class DoubleExpression extends Expression {
  public double value;

  public DoubleExpression(double value) {
    this.value = value;
  }

  @Override
  public void accept(Visitor visitor) {
    if (visitor instanceof ExpressionVisitor) {
      ((ExpressionVisitor) visitor).visit(this);
    }
  }
}

class AdditionExpression extends Expression {
  public Expression left, right;

  public AdditionExpression(Expression left, Expression right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public void accept(Visitor visitor) {
    if (visitor instanceof AdditionExpressionVisitor) {
      ((AdditionExpressionVisitor) visitor).visit(this);
    }
  }
}

class ExpressionPrinter implements DoubleExpressionVisitor, AdditionExpressionVisitor {
  private StringBuilder sb = new StringBuilder();

  @Override
  public void visit(DoubleExpression obj) {
    sb.append(obj.value);
  }

  @Override
  public void visit(AdditionExpression obj) {
    sb.append('(');
    obj.left.accept(this);
    sb.append('+');
    obj.right.accept(this);
    sb.append(')');
  }

  @Override
  public String toString() {
    return sb.toString();
  }
}

class AcyclicVisitorDemo {
  public static void main(String[] args) {
    AdditionExpression e = new AdditionExpression(
        new DoubleExpression(1),
        new AdditionExpression(
          new DoubleExpression(2),
          new DoubleExpression(3)
        )
    );
    ExpressionPrinter ep = new ExpressionPrinter();
    ep.visit(e);
    System.out.println(ep.toString());
  }
}