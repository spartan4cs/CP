import java.util.Scanner;

public class BuyandSell5_2TransactionAllowed {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = sc.nextInt();
        }

        // left to right
        int least = prices[0];
        int[] dp_left = new int[prices.length];

        for (int i = 1; i < prices.length; i++) {
            least = Math.min(least, prices[i]);// best buying point
            int profit = prices[i] - least;
            dp_left[i] = Math.max(profit, dp_left[i - 1]);
        }

        // right to left
        int maximum = prices[prices.length - 1];
        int[] dp_right = new int[prices.length];

        for (int i = prices.length - 2; i >= 0; i--) {
            maximum = Math.max(maximum, prices[i]); // best selling point
            int profit = maximum - prices[i];
            dp_right[i] = Math.max(profit, dp_right[i + 1]);
        }

        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            ans = Math.max(ans, dp_left[i] + dp_right[i]);
        }
        System.out.println(ans);
    }
}
