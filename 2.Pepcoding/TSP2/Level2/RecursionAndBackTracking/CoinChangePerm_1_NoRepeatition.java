import java.io.*;
import java.util.*;

public class CoinChangePerm_1_NoRepeatition {
    // write your code here

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();
        boolean[] used = new boolean[coins.length];

        // coins on option
        coinChange1_Myappraoch(coins, amt, "", used);
    }

    private static void coinChange1_Myappraoch(int[] coins, int amt, String asf, boolean[] used) {

        if (amt == 0) {
            System.out.println(asf + ".");
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            if (amt - coin >= 0 && !used[i]) {
                used[i] = true;
                coinChange1_Myappraoch(coins, amt - coin, asf + coin + "-", used);
                used[i] = false;
            }
        }

    }
}
