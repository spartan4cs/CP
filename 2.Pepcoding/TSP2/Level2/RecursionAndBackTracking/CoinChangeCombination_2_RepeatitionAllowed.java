import java.util.Scanner;

public class CoinChangeCombination_2_RepeatitionAllowed {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();

        // coins on option
        // same coin can be used multiple times

        coinCombination2(coins, 0, amt, "", 0);
    }

    private static void coinCombination2(int[] coins, int cl, int amt, String asf, int lo) {

        if (amt == 0) {
            System.out.println(asf + ".");
            return;
        }
        if (amt < 0) {
            return;
        }

        for (int i = lo; i < coins.length; i++) {
            int coin = coins[i];
            if (amt - coin >= 0) {

                coinCombination2(coins, cl, amt - coin, asf + coin + "-", i);
            }
        }
    }

}
