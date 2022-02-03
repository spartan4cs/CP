import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class IsPrime {
    public static void main(String[] args) {
        System.out.println(isPrime(4));
        System.out.println(sumwithPre(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), i -> i % 2 == 0));
        System.out.println(findSquareOfMaxSum(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        ;
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
