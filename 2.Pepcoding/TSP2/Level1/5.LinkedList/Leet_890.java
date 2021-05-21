import java.util.*;

public class Leet_890 {

    public static String getPattern(String s) {

        int index = 1;
        int fc[] = new int[26];
        int res = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int chi = ch - 'a';
            if (fc[chi] == 0) {

                fc[chi] = index;
                index++;
            }
            res += index;
        }
        return res;

    }

    // assigning index to every char
    public static List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> res = new ArrayList<>();
        String patter1 = getPattern(pattern);
        for (String word : words) {
            String pattern2 = getPattern(word);
            if (patter1.equals(pattern2)) {
                res.add(word);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        String[] words = { "abc", "deq", "mee", "aqq", "dkd", "ccc" };
        String pattern = "abb";
        findAndReplacePattern(words, pattern).forEach(p -> System.out.println(p));

    }
}
