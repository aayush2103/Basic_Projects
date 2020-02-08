package hackerRank;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface Greeting{
	default void hello() {
		System.out.println("hello from A");
	}
}
interface GreetingImpl extends Greeting{
	default void hello() {
		System.out.println("hello from B");
	}
}
public class demo implements Greeting, GreetingImpl{
	public static void main(String[] args) {
		new demo().hello();
	}
}
