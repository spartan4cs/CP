import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    
    public static class Pair {
        int l;
        int i;
        int v;
        String psf;
        
        Pair(int i, int v, int l, String psf){
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }
        
    public static void solution(int []arr){
// write your code here

        int n=arr.length;
        int dp[] = new int[n];

        dp[0]=1;
        int om=1;
        for(int i=1;i<n;i++){

            int max=0;
            for( int j=i-1; j>=0;j--){
                if(arr[j]<arr[i] ){
                    max = Math.max(max,dp[j]);
                }
            }

            dp[i]=1+max;
            //System.out.println("dp["+i+"] = "+dp[i]);
            om = Math.max(om,dp[i]);
        }
        System.out.println(om);


        //print
        Queue<Pair> q= new ArrayDeque<>();
        for(int i = 0; i <n; i++){
            if(dp[i]==om)
                q.add(new Pair(i,arr[i],dp[i],arr[i]+""));

        }

        while(q.size()>0){

            Pair rem = q.remove();
            int i=rem.i;  //index
            int v=rem.v; //vertex
            int l =rem.l;  //count
            String asf = rem.psf;

            if(l==1){
                System.out.println(asf);
                continue;
            }

            for(int j=i-1;j>=0;j--){
                if(dp[j]+1==dp[i] && arr[i]>arr[j]){
                    q.add(new Pair(j,arr[j],dp[j],arr[j]+" -> "+asf));
                }
            }


        }

    }
    
    
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}
