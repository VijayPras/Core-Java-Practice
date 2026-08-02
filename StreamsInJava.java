/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.util.stream.*;

public class StreamsInJava
{
	public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 8, 8, 2, 3, 4, 6, 8, 9, 0, 1, 2134, 5341, 22, 21);
        System.out.println("Original List: " + list);
        
        // Filtering
        List<Integer> filteredList = list.stream().
            filter(x -> x % 2 == 0).
            collect(Collectors.toList());
        System.out.println("Filtered List: " + filteredList);
        
        // Mapping
        List<Integer> mappedList = filteredList.stream().
            map(x -> (x / 2)).
            collect(Collectors.toList());
        System.out.println("Mapped List: " + mappedList);
        
        // Altogether at once:
        List<Integer> mappedFilteredList = list.stream().
            filter(x -> x % 2 == 0).
            map(x -> (x / 2)).
            collect(Collectors.toList());
        System.out.println("Mapped Filtered List: " + mappedFilteredList);
        
        // Distinct
        List<Integer> distinctList = list.stream().
            filter(x -> x % 2 == 0).
            map(x -> (x / 2)).
            distinct().
            collect(Collectors.toList());
        System.out.println("Distinct List: " + distinctList);
        
        // Sorted ascendingly
        List<Integer> sortedAscList = list.stream().
            filter(x -> x % 2 == 0).
            map(x -> (x / 2)).
            distinct().
            sorted().
            collect(Collectors.toList());
        System.out.println("Sorted List: " + sortedAscList);
        
        // Sorted descendingly
        List<Integer> sortedDescList = list.stream().
            filter(x -> x % 2 == 0).
            map(x -> (x / 2)).
            distinct().
            sorted((a, b) -> (b - a)).  // Descending
            collect(Collectors.toList());
        System.out.println("Sorted Descending List: " + sortedDescList);

        // Limit
        List<Integer> limitedList = list.stream().
            filter(x -> x % 2 == 0).
            map(x -> (x / 2)).
            distinct().
            sorted((a, b) -> (b - a)).  // Descending
            limit(2).
            collect(Collectors.toList());
        System.out.println("Limited List: " + limitedList);

        // Skip an element
        List<Integer> skipAnElementList = list.stream().
            filter(x -> x % 2 == 0).
            map(x -> (x / 2)).
            distinct().
            sorted((a, b) -> (b - a)).  // Descending
            limit(4).
            skip(1).
            collect(Collectors.toList());
        System.out.println("Skipped an element List: " + skipAnElementList);

        // Using Streams to get first 100 elements, skip 1
        List<Integer> outputList = Stream.iterate(0, x -> x + 1).limit(101).skip(1).collect(Collectors.toList());
        System.out.println(outputList);

        // Peek
        List<Integer> peekedList = Stream.iterate(0, x -> x + 1)
            .limit(101)
            .skip(1)
            .filter(x -> x % 2 == 0)
            .map(x -> x / 10)
            .distinct()
            .sorted()
            .peek(x -> System.out.println(x))
            .collect(Collectors.toList());
        System.out.println("Edited List: " + peekedList);

        // Max
        Integer integer = Stream.iterate(0, x -> x + 1)
          .limit(101)
          .skip(1)
          .map(x -> x / 20)
          .distinct()
          .peek(System.out::println)
          .max((a, b) -> b - a)
          .get();
        System.out.println("Max value: " + integer);

        // count
        Long totalCount = Stream.iterate(0, x -> x + 1)
          .limit(101)
          .skip(1)
          .map(x -> x / 20)
          .distinct()
          .count();
        System.out.println("Total count: " + totalCount);

        // parallelStream
        List<Integer> ourList = Stream.iterate(0, x -> x + 1)
          .limit(10000)
          .skip(1)
          .map(x -> x / 20)
          .distinct()
          .collect(Collectors.toList());
        List<Integer> hugeList = ourList.parallelStream().filter(x -> x % 2 == 0).
            map(x -> (x / 2)).
            distinct().
            sorted((a, b) -> (b - a)).  // Descending
            limit(4).
            skip(1).
            collect(Collectors.toList());
      // Not printing anything but essentially, it gives a huge list. Parallel stream is the same as stream but divides tasks into chunks for easier processing.
	}
}
