import java.util.HashMap;
import java.util.Scanner;

public class Word_K_Selection_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next;
        int k = sc.nextInt();

        // need to select k distinct chars

        // get unique string
        HashMap<Character, Integer> fmap = new HashMap();

        String ustr = "";
        for (char c : s.toCharArray()) {
            if (fmap.containsKey(c)) {
                fmap.put(c, fmap.get(c) + 1);
            } else {
                fmap.put(c, 1);
                ustr += c;
            }
        }
        System.out.println(ustr);
    }
}
