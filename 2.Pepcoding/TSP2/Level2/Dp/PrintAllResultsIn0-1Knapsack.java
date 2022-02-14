import java.io.*;
import java.util.*;

public class Main {

    public static class Pair{
        int i,j;
        String psf;
        public Pair(int i,int j, String psf){
            this.i=i; this.j =j ; this.psf =psf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        //write your code here

        int dp[][] = new int[n+1][cap+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=cap;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=wts[i-1]){
                    //played
                   dp[i][j]= Math.max(dp[i][j], values[i-1]+dp[i-1][j-wts[i-1]]);
                }
            }
        }
        System.out.println(dp[n][cap]);

        //print ans

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n,cap, ""));

        while(q.size()>0){
            Pair rem = q.remove();
            int i=rem.i;
            int j=rem.j;
            String asf=rem.psf;
            

            //base
            if(i==0|| j==0){
                System.out.println(asf+" ");
                continue;
            }

            //yes
            if(j>=wts[i-1] && dp[i][j]==values[i-1]+dp[i-1][j-wts[i-1]]){   
                q.add(new Pair(i-1,j-wts[i-1],(i-1)+" "+asf));
            }
            //no
            if(dp[i][j]==dp[i-1][j]){
                q.add(new Pair(i-1,j,asf));
            }

        }


        
    }
}
