import java.util.Scanner;

class BuyandSell4_CooldownAndInfiniteTransactionAllowed {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int prices[] = new int[n];

        for (int i = 0; i < prices.length; i++) {
            prices[i] = sc.nextInt();
        }

        int bsp = -prices[0];
        int ssp = 0;
        int csp = 0;

        for (int i = 1; i < prices.length; i++) {

            int new_bsp = Math.max(bsp, csp - prices[i]);
            int new_ssp = Math.max(ssp, bsp + prices[i]);
            int new_csp = Math.max(csp, ssp);

            bsp = new_bsp;
            ssp = new_ssp;
            csp = new_csp;
        }
        System.out.println(Math.max(csp, ssp));
    }
}