package structural.flyweight;

import java.util.ArrayList;
import java.util.List;

// Flyweight - A space optimization technique that lets us use less memory by storing externally the data
//   associated with similar objects
/*    1. store common data externally
      2. specify an index or a reference into the external data store
      3. define the idea of 'ranges' on homogeneous collections and store data related to those ranges
      4. don't forget String.intern()
* */
class FormattedText {
  private String plainText;
  private boolean [] capitalize;

  public FormattedText(String plainText) {
    this.plainText = plainText;
    capitalize = new boolean[plainText.length()];
  }

  public void capitalize(int start, int end) {
    for (int i = start; i <= end; ++i)
      capitalize[i] = true;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < plainText.length(); ++i) {
      char c = plainText.charAt(i);
      sb.append(capitalize[i] ? Character.toUpperCase(c) : c);
    }
    return sb.toString();
  }
}

// 2. better than 1.
class BetterFormattedText {
  private String plainText;
  private List<TextRange> formatting = new ArrayList<>();

  public BetterFormattedText(String plainText)
  {
    this.plainText = plainText;
  }

  public TextRange getRange(int start, int end) {
    TextRange range = new TextRange(start, end);
    formatting.add(range);
    return range;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < plainText.length(); ++i) {
      char c = plainText.charAt(i);
      for (TextRange range : formatting)
        if (range.covers(i) && range.capitalize)
          c = Character.toUpperCase(c);
      sb.append(c);
    }
    return sb.toString();
  }

  public class TextRange {
    public int start, end;
    public boolean capitalize, bold, italic;

    public TextRange(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public boolean covers(int position)
    {
      return position >= start && position <= end;
    }
  }
}

class TextFormattingDemo {
  public static void main(String[] args) {
    // 1.
    FormattedText ft = new FormattedText("This is a brave new world");
    ft.capitalize(10, 15);
    System.out.println(ft);

    // 2.
    BetterFormattedText bft = new BetterFormattedText("Make America Great Again");
    bft.getRange(13, 18).capitalize = true;
    System.out.println(bft);
  }
}