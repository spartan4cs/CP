class Solution {
    public int numSquares(int n) {
        
        
        int []dp = new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int count=1;
            int min=Integer.MAX_VALUE;;
            while(i-count*count >=0){
                min = Math.min(min,dp[i-count*count]);
                
                count++;
            }
            
            dp[i]=min+1;
        }
        
        return dp[n];
    }
}
