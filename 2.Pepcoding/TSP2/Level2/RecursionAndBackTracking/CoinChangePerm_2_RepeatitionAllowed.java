import java.io.*;
import java.util.*;

public class CoinChangePerm_2_RepeatitionAllowed {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();
        // boolean[] used = new boolean[coins.length];

        // coins on option
        coinChange2_Myappraoch(coins, amt, "");
    }

    private static void coinChange2_Myappraoch(int[] coins, int amt, String asf) {

        if (amt == 0) {
            System.out.println(asf + ".");
            return;
        }

        for (int coin : coins) {

            if (amt - coin >= 0)
                coinChange2_Myappraoch(coins, amt - coin, asf + coin + "-");

        }
    }
}
