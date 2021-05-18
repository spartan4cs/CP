import java.util.Arrays;
import java.util.stream.Stream;

public class Leet_coinchange {

    public static int coinChange(int[] coins, int amount) {

     int []dp = new int[amount+1];
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            dp[i]=-1;
            for(int coin :coins){
                if(i-coin>=0 && dp[i-coin]!=-1)
                {
                    int min = dp[i-coin]+1;
                    if(dp[i]==-1)
                        dp[i]=min;
                    else if(min<dp[i])
                        dp[i]=min;
                }
            }
        }
        return dp[amount];

    }

    public static void main(String[] args) {
        // [3,7,405,436]
        // 8839
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    // Example 1:

    // Input: coins = [1,2,5], amount = 11
    // Output: 3
    // Explanation: 11 = 5 + 5 + 1
    // Example 2:

    // Input: coins = [2], amount = 3
    // Output: -1
    // Example 3:

    // Input: coins = [1], amount = 0
    // Output: 0
    // Example 4:

    // Input: coins = [1], amount = 1
    // Output: 1
    // Example 5:

    // Input: coins = [1], amount = 2
    // Output: 2
}
