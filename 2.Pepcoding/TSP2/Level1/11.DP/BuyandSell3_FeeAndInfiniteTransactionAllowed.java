import java.util.Scanner;

class BuyandSell3_FeeAndInfiniteTransactionAllowed {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int prices[] = new int[n];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = sc.nextInt();
        }
        int fee = sc.nextInt();

        // logic;

        int bsp = -prices[0];
        int ssp = 0;

        for (int i = 1; i < prices.length; i++) {

            int new_bsp = Math.max(bsp, ssp - prices[i]);
            int new_ssp = Math.max(ssp, bsp + prices[i] - fee);
            bsp = new_bsp;
            ssp = new_ssp;
        }
        System.out.println(ssp);
    }
}