import java.util.Arrays;

class SeiveOfErathothenes {

    public static boolean[] seive(int hi) {
        boolean[] isPrime = new boolean[hi + 1];

        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= hi; i++) {
            if (isPrime[i] == true) {

                for (int j = i + i; j <= hi; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {

        boolean[] isPrime = seive(50);
        System.out.println(isPrime[5]);
    }
}