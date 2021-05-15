
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER. The function accepts following
     * parameters: 1. STRING n 2. INTEGER k
     */

    public static int superDigit(String n, int k) {
        // Write your code here

        if (n.length() == 1 && n.charAt(0) - '0' >= 0 && n.charAt(0) - '0' <= 9) {
            return n.charAt(0) - '0';
        }

        long sum = getSum(n);
        return superDigit(Long.toString(sum * k), 1);
    }

    private static long getSum(String n) {
        long sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += n.charAt(i) - '0';
        }
        return sum;
    }

}

public class HackerRankRecursiveDigit_sum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}