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

      int dp[][] = new int[n][m];
      for(int j=m-1;j>=0;j--){
         for(int i=0;i<n;i++){
            if(j==m-1){
               dp[i][j] = arr[i][j];
            }else if(i==0){
               dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
            }else if(i==n-1){
               dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
            }else{
               dp[i][j] = arr[i][j] + Math.max(dp[i+1][j+1],Math.max(dp[i][j+1], dp[i-1][j+1]));
            }
         }
      }
      int max =dp[0][0];
      int mi = 0;
      for(int i=0;i<n;i++){
         if(dp[i][0]>max){

            max = dp[i][0];
         
         }

      }
      System.out.println(max);

      //print job

      Queue<Pair> q= new ArrayDeque<>();
      for(int i=0;i<n;i++){
         if(dp[i][0]==max){

            q.add(new Pair(i+"" , i,0));      
         }

      }
      int xarr[] ={-1,0,1};
      int yarr[] ={1,1,1};

      while(q.size()>0){

         Pair rem = q.remove();
         int i=rem.i;
         int j = rem.j;
         String asf = rem.psf;

         if(j==m-1){
             System.out.println(asf )  ;
             continue;
         }
        /* if(j==m-1){
             System.out.println(asf )  ;
             continue;
         }else if(i==0){
            if(dp[i][j+1]>dp[i+1][j+1]){
               q.add(new Pair(asf+" "+"d2" , i,j+1));
            }else if(dp[i][j+1]<dp[i+1][j+1]){
               q.add(new Pair(asf+" "+"d3" , i+1,j+1));

            }else{
               q.add(new Pair(asf+" "+"d2" , i,j+1));
               q.add(new Pair(asf+" "+"d3" , i+1,j+1));
 
            }
         }else if(i==n-1){
            if(dp[i][j+1]>dp[i-1][j+1]){
               q.add(new Pair(asf+" "+"d2" , i,j+1));
            }else if(dp[i][j+1]<dp[i-1][j+1]){
               q.add(new Pair(asf+" "+"d1" , i-1,j+1));

            }else{
               q.add(new Pair(asf+" "+"d1" , i-1,j+1));
               q.add(new Pair(asf+" "+"d2" , i,j+1));
 
            }
         }else{
            int temp =Math.max(dp[i+1][j+1],Math.max(dp[i][j+1], dp[i-1][j+1]));
            if(temp ==dp[i-1][j+1])
               q.add(new Pair(asf+" "+"d1" , i-1,j+1));
            if(temp ==dp[i][j+1])
               q.add(new Pair(asf+" "+"d2" , i,j+1));

            if(temp ==dp[i+1][j+1])
               q.add(new Pair(asf+" "+"d3" , i+1,j+1));
         }*/

         int maxval =getmax(i,j,dp);
         for(int d=1;d<=3;d++){
            int ni = i+xarr[d-1];
            int nj = j+yarr[d-1];

            if(ni>=0 && ni<n && nj>=0 && nj <m){

               if(dp[ni][nj]==maxval)
                  q.add(new Pair(asf+" "+"d"+d,ni,nj));
            }
         }

         
      }


      
   }
   private static int getmax(int i,int j,int [][]dp){
      int n=dp.length;
      int m = dp[0].length;
            if(i==0){
               return Math.max(dp[i][j+1], dp[i+1][j+1]);
            }else if(i==n-1){
               return Math.max(dp[i][j+1], dp[i-1][j+1]);
            }else{
               return Math.max(dp[i+1][j+1],Math.max(dp[i][j+1], dp[i-1][j+1]));
            }
   }


}
