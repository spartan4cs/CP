import java.util.Scanner;

public class FriendsPairing2 {
    static int counter = 1;

    public static void solution(int i, int n, boolean[] used, String asf) {
        // write your code here+

        if (i > n) {
            System.out.println(counter++ + "." + asf);
            return;
        }

        if (!used[i]) {

            // single call
            used[i] = true;
            solution(i + 1, n, used, asf + "(" + i + ") ");
            // other number call
            for (int j = i + 1; j <= n; j++) {
                if (!used[j]) {

                    used[j] = true;
                    solution(i + 1, n, used, asf + "(" + i + "," + j + ") ");
                    used[j] = false;
                }
            }
            used[i] = false;

        } else {
            // no call
            solution(i + 1, n, used, asf);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] used = new boolean[n + 1];
        solution(1, n, used, "");
    }
}
