import java.util.Scanner;

class LargestNoPossibleAfterKSwaps {

    static String max;

    public static void findMaximum(String str, int k) {
        // write your code here
        if (Integer.parseInt(str) > Integer.parseInt((max))) {
            max = str;
        }
        if (k == 0) {
            return;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                // right >left then swap
                if (str.charAt(j) > str.charAt(i)) {

                    str = swap(str, i, j);
                    findMaximum(str, k - 1);
                    str = swap(str, i, j);
                }
            }
        }

    }

    private static String swap(String str, int i, int j) {

        char ith = str.charAt(i);
        char jth = str.charAt(j);

        String left = str.substring(0, i);
        String mid = str.substring(i + 1, j);
        String right = str.substring(j + 1);
        return left + jth + mid + ith + right;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        max = str;
        findMaximum(str, k);
        System.out.println(max);
    }
}