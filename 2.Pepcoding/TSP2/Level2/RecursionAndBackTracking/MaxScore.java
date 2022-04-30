import java.util.HashMap;
import java.util.Scanner;

public class MaxScore {

    // 4
    // dog cat dad good
    // 9
    // a b c d d d g o o
    // 1 0 9 5 0 0 3 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();

        }
        int a = sc.nextInt();
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < a; i++) {
            char ch = sc.next().charAt(0);
            if (fmap.containsKey(ch)) {
                fmap.put(ch, fmap.get(ch) + 1);
            } else {
                fmap.put(ch, 1);
            }
        }
        int[] score = new int[26];
        for (int i = 0; i < score.length; i++) {

            score[i] = sc.nextInt();
        }

        System.out.println(solution(words, fmap, score, 0));
    }

    // 4
    // dog cat dad good
    // 9
    // a b c d d d g o o
    // 1 0 9 5 0 0 3 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0
    private static int solution(String[] words, HashMap<Character, Integer> fmap, int[] score, int cl) {

        if (cl == words.length) {
            return 0;
        }

        // no call
        int sno = solution(words, fmap, score, cl + 1);
        // yes call
        String cw = words[cl];

        int cl_score = 0;
        boolean flag = true;
        for (int i = 0; i < cw.length(); i++) {

            char ch = cw.charAt(i);
            if (!fmap.containsKey(ch) || fmap.get(ch) <= 0) {
                flag = false;
            }
            if (fmap.containsKey(ch)) {
                fmap.put(ch, fmap.get(ch) - 1);
            }

            cl_score += score[ch - 'a'];
        }

        int syes = 0;
        if (flag) {

            syes = cl_score + solution(words, fmap, score, cl + 1);
        }
        for (int i = 0; i < cw.length(); i++) {

            char ch = cw.charAt(i);
            if (fmap.containsKey(ch)) {
                fmap.put(ch, fmap.get(ch) + 1);
            }

        }

        return Math.max(sno, syes);

    }
}
