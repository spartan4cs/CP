import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IsPrime {
    public static void main(String[] args) {
        System.out.println(isPrime(4));
        System.out.println(sumwithPre(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), i -> i % 2 == 0));
        System.out.println(findSquareOfMaxSum(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        ;

        // Stream

        Integer[] arr = Stream.of(1, 2, 3, 4).toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr));
        String[] strArr = Stream.of("abc", "def", "ghi").toArray(String[]::new);
        System.out.println(Arrays.toString(strArr));
        List<String> listOfString = Stream.of("abc", "def", "ghi").map(i -> i.toUpperCase())
                .collect(Collectors.toList());
        listOfString.forEach(i -> System.out.println(i));

        Set<String> setString = Stream.of("abc", "def", "ghi").map(i -> i.toUpperCase())
                .collect(Collectors.toSet());

        // sorting

        Stream<String> names2 = Stream.of("aBc", "d", "ef", "123456");
        List<String> reverseSorted = names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(reverseSorted); // [ef, d, aBc, 123456]

        Stream<String> names3 = Stream.of("aBc", "d", "ef", "123456");
        List<String> naturalSorted = names3.sorted().collect(Collectors.toList());
        System.out.println(naturalSorted);

        // flatmap
        Stream<List<String>> namesOriginalList = Stream.of(
                Arrays.asList("Pankaj"),
                Arrays.asList("David", "Lisa"),
                Arrays.asList("Amit"));
        // flat the stream from List<String> to String stream
        Stream<String> flatStream = namesOriginalList
                .flatMap(strList -> strList.stream());
        String[] flatString = flatStream.toArray(String[]::new);
        System.out.println(Arrays.toString(flatString));
        // flatStream.forEach(System.out::println);
    }

    public static boolean isPrime(int n) {
        IntPredicate divisible = i -> n % i == 0;
        return n > 1 && IntStream.range(2, n).noneMatch(divisible);
    }

    public static int sumwithPre(List<Integer> list, Predicate<Integer> p) {

        return list.parallelStream().filter(p).mapToInt(i -> i).sum();
    }

    public static int findSquareOfMaxSum(List<Integer> list) {

        return list.stream().filter(i -> i % 2 != 0).filter(s -> s > 3).filter(i -> i < 11)
                .max(Comparator.naturalOrder()).map(i -> i * i).get();

    }
}
