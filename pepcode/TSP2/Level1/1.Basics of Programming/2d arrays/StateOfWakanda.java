import java.util.Scanner;

class StateOfWakanda {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int j = 0; j < m; j++) {
            if(j%2==0){
                for (int i = 0; i < n; i++) {
                    System.out.println(arr[i][j]);
                }
            }else{
                for (int i = n-1; i >=0; i--) {
                    System.out.println(arr[i][j]);
                }
            }
           
        }
    }
}