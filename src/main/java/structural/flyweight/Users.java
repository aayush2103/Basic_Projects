package structural.flyweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class User {
  private String fullName;

  public User(String fullName) {
    this.fullName = fullName;
  }
}

// 2.
class User2 {
  static List<String> strings = new ArrayList<>();
  private int[] names;

  public User2(String fullName) {
    Function<String, Integer> getOrAdd = (String s) -> {
      int idx = strings.indexOf(s);
      if (idx != -1) return idx;
      else {
        strings.add(s);
        return strings.size() - 1;
      }
    };

    names = Arrays.stream(fullName.split(" "))
      .mapToInt(s -> getOrAdd.apply(s)).toArray();
  }

  public String getFullName() {
    return Arrays.stream(names).mapToObj(i -> strings.get(i))
      .collect(Collectors.joining(","));
  }
}

class UsersDemo {
  public static void main(String[] args) {
    // 1. below names have "Smith" in common which is basically waisting 5 bytes per repetition
    User user = new User("John Smith");
    User user1 = new User("Jane Smith");

    // 2. now we use the new User2 API which basically saves repetition names and a space as well
    User2 user2 = new User2("John Smith");
    User2 user3 = new User2("Jane Smith");
  }
}