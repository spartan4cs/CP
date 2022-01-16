import java.util.*;

class BuyandSell_1TransactionAllowed {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = sc.nextInt();
        }

        int least = Integer.MAX_VALUE;
        int ans = 0;
        for (int price : prices) {
            least = Math.min(least, price);
            int profit = price - least;
            ans = Math.max(ans, profit);
        }
        System.out.println(ans);
    }
}