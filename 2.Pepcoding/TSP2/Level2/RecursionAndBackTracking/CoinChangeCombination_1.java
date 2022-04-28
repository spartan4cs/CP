import java.util.Scanner;

public class CoinChangeCombination_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();

        // coins on level
        // yes and no
        coinCombination1(0, amt, coins, 0, "");

        // coins on option
        coinCombination2(coins, 0, amt, "", -1);
    }

    private static void coinCombination1(int ssf, int ts, int[] coins, int cl, String asf) {

        // base
        if (cl == coins.length) {
            if (ssf == ts) {
                System.out.println(asf + ".");
            }
            return;
        }

        // yes call
        if (ssf + coins[cl] <= ts)
            coinCombination1(ssf + coins[cl], ts, coins, cl + 1, asf + coins[cl] + "-");

        // no call
        coinCombination1(ssf, ts, coins, cl + 1, asf);

    }

    // coins on option
    private static void coinCombination2(int[] coins, int cl, int amt, String asf, int lp) {

        if (amt == 0) {
            System.out.println(asf + ".");
            return;
        }
        if (amt < 0) {
            return;
        }

        for (int i = lp + 1; i < coins.length; i++) {
            int coin = coins[i];
            if (amt - coin >= 0) {

                coinCombination2(coins, cl, amt - coin, asf + coin + "-", i);
            }
        }
    }
}
