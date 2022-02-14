import java.io.*;
import java.util.*;

public class Main {

   private static class Pair {
      String psf;
      int i;
      int j;

      public Pair(String psf, int i, int j) {
         this.psf = psf;
         this.i = i;
         this.j = j;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }

      //write your code here

      //naive top down
      //two possible choices H and V and explore all the possibel path
      // and get the min in base case

      //dp bottom up 


      int dp[][] = new int[n][m];

      for(int i=n-1;i>=0;i--){
         for(int j=m-1;j>=0;j--){
            

            if(i==n-1 && j==m-1){ //last box
               dp[i][j] = arr[i][j];
            }else if(i==n-1){ //last row
               dp[i][j]=dp[i][j+1] + arr[i][j];
            }else if(j==m-1){ //last column
               dp[i][j] = dp[i+1][j] + arr[i][j];

            }else{
                dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]) +arr[i][j];  
            }
         }
      }
      System.out.println(dp[0][0]);


      //can have multiple path so use queue

      Queue<Pair> q= new LinkedList<>();

      q.add(new Pair("",0,0));

      while(q.size()>0){
         Pair rem = q.remove();

         int i=rem.i;
         int j=rem.j;

         if(i==n-1 && j==m-1){
            System.out.println(rem.psf);
            continue;

         }
         if(i==n-1){//last row  so can move horizontally
            q.add(new Pair(rem.psf+"H",i,j+1));
         }else if(j==m-1){ //last col so can move vertically
            q.add(new Pair(rem.psf+"V",i+1,j));
         }else{
            if(dp[i+1][j]<dp[i][j+1]){
               q.add(new Pair(rem.psf+"V",i+1,j));
            }else if(dp[i+1][j]>dp[i][j+1]){
               q.add(new Pair(rem.psf+"H",i,j+1));

            }else{
               q.add(new Pair(rem.psf+"V",i+1,j));
               q.add(new Pair(rem.psf+"H",i,j+1));

            }
         }

      }

      
   }

}
