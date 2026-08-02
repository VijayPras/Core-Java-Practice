import java.util.*;
import java.util.stream.*;

public class LambdaInJava
{
	public static void main(String[] args) {
    // Runnable is a functional interface. Functional interface is an interface with only one abstract method. This is because it would be convenient to use lambda expressions.
    Runnable runnable = () -> {
      for(int i = 0; i < 10; i++) { System.out.println("Hello_" + i); }
    };
    Thread childThread = new Thread(runnable);
    childThread.run();

    // Comparator is another functional interface.
    List<Integer> list = new ArrayList<>();
    list.add(2); list.add(7); list.add(1); list.add(9); list.add(3); list.add(4);
    Collections.sort(list, (a, b) -> a - b);
    System.out.println("Ascending: " + list);
    Collections.sort(list, (a, b) -> b - a);
    System.out.println("Descending: " + list);

    // Use of TreeSet example in Comparator:
    Set<Integer> unsortedSet = new TreeSet<>();
    unsortedSet.add(22);
    unsortedSet.add(1);
    unsortedSet.add(14);
    System.out.println("Unsorted set: " + unsortedSet);
    Set<Integer> sortedSet = new TreeSet<>((a, b) -> b - a);
    sortedSet.add(22);
    sortedSet.add(1);
    sortedSet.add(14);
    System.out.println("Sorted set: " + sortedSet);
	}
}
