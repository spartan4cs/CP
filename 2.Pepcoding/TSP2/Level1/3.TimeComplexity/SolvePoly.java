public class SolvePoly {

    // poly1 = f(x,n) = 1.x^n + 2.x^n-1 + 3.x^n-2 + ... + n.x^1

    public static int poly1(int x, int N) {

        int xval = x;
        int sum = 0;
        for (int n = N; n >= 1; n--) {

            sum += n * xval;
            xval = xval * x;
        }

        return sum;
    }

    public static void main(String[] args) {

        int x = poly1(2, 5);
        System.out.println(x);// 1114
    }
}
