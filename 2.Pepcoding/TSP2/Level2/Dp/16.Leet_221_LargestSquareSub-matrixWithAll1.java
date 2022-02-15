import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[][] arr) {
		//write your code here

		int n = arr.length;
		int m = arr[0].length;
		int dp[][] = new int[n][m];
		int max=  Integer.MIN_VALUE;
		for(int i=n-1;i>=0;i--){
			for(int j=m-1;j>=0;j--){
				if(i==n-1||j==m-1 || arr[i][j]==0){
					dp[i][j]=arr[i][j];

				}else{
					dp[i][j] = Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i+1][j+1])+1;
				}
				max=Math.max(max,dp[i][j]);
			}	
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m =scn.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0 ; i < n; i++){
			for(int j = 0 ; j < m; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		System.out.println(solution(arr));
	}

}
