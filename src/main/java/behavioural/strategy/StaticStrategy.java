package behavioural.strategy;

import java.util.List;
import java.util.function.Supplier;

/* Strategy - enables the exact behavior of a system to be selected either
     at run-time (dynamic) or compile-time (static)
     Also known as 'policy' in the C++ world

     1. define an algorithm at a high level
     2. define the interface you expect each strategy to follow
     3. provide for either dynamic or static composition of strategy in the overall algorithm
*/
interface ListStrategy {
  default void start(StringBuilder sb) {}
  void addListItem(StringBuilder stringBuilder, String item);
  default void end(StringBuilder sb) {}
}

class MarkdownListStrategy implements ListStrategy {
  @Override
  public void addListItem(StringBuilder stringBuilder, String item) {
    stringBuilder.append(" * ").append(item)
      .append(System.lineSeparator());
  }
}

class HtmlListStrategy implements ListStrategy {
  @Override
  public void start(StringBuilder sb)
  {
    sb.append("<ul>").append(System.lineSeparator());
  }

  @Override
  public void addListItem(StringBuilder stringBuilder, String item) {
    stringBuilder.append("  <li>")
      .append(item)
      .append("</li>")
      .append(System.lineSeparator());
  }

  @Override
  public void end(StringBuilder sb)
  {
    sb.append("</ul>").append(System.lineSeparator());
  }
}

class TextProcessor<LS extends ListStrategy> {
  private StringBuilder sb = new StringBuilder();
  // cannot do this
  // private LS listStrategy = new LS();
  private LS listStrategy;

  public TextProcessor(Supplier<? extends LS> ctor)
  {
    listStrategy = ctor.get();
  }

  // the skeleton algorithm is here
  public void appendList(List<String> items) {
    listStrategy.start(sb);
    for (String item : items)
      listStrategy.addListItem(sb, item);
    listStrategy.end(sb);
  }

  public void clear()
  {
    sb.setLength(0);
  }

  @Override
  public String toString()
  {
    return sb.toString();
  }
}

class DynamicStrategyDemo {
  public static void main(String[] args) {
    TextProcessor<MarkdownListStrategy> tp = new TextProcessor<>(
      MarkdownListStrategy::new);
    tp.appendList(List.of("liberte", "egalite", "fraternite"));
    System.out.println(tp);

    TextProcessor<HtmlListStrategy> tp2 = new TextProcessor<>(HtmlListStrategy::new);
    tp2.appendList(List.of("inheritance", "encapsulation", "polymorphism"));
    System.out.println(tp2);
  }
}