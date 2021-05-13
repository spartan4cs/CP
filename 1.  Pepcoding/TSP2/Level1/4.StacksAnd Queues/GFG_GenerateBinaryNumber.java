import java.util.*;

public class GFG_GenerateBinaryNumber {

    // add and offer
    // offer will return tru or false
    // add will give true / exception if failed to insert
    // similarly for remove and poll
    static ArrayList<String> generate(long n) {
        Queue<String> q = new ArrayDeque<>();
        ArrayList<String> a = new ArrayList<>();
        q.offer("1");

        while (n-- > 0) {
            String s = q.poll();
            a.add(s);
            q.offer(s + "0");
            q.offer(s + "1");
        }
        return a;
    }

    public static void main(String[] args) {

        long n = 5;

        generate(n).forEach(p -> System.out.println(p));

    }
}
