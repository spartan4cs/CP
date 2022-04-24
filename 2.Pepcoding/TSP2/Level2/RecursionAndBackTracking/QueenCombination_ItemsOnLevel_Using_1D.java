
import java.io.*;
import java.util.*;

public class Main {


//lcno -last cell no
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        // write your code here
        
        //base
        if(qpsf==tq){
            for(int row=0;row<chess.length;row++){
                for(int col=0;col<chess.length;col++){
                    if(chess[row][col]==true){
                        System.out.print("q\t");
                    }else{
                        System.out.print("-\t");
                    }
                }
                System.out.println();
                
            }
            System.out.println();
        }
        
        
        //rather than considering 2d 
        //consider as 1d- 16 box
        //then visualize combination 1d  -item on level
        
        
        for(int cell = lcno+1; cell<chess.length*chess.length;cell++){
            int row = cell/chess.length;
            int col = cell%chess.length;
            
            chess[row][col]=true;
            queensCombinations(qpsf+1,tq,chess,cell);
            chess[row][col]=false;
        }
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}
