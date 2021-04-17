import java.util.Scanner;

class MaxOfArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        // max = printArrJateHue(0, arr, max);// from 0 to n-1 , i will get max element
        max = printArrVapasAteHue(0, arr, max);// from 0 to n-1 , i will get max element

        System.out.println(max);
    }

    public static int printArrJateHue(int i, int[] arr, int max) {

        // ye jate hue max nikala
        if (i <= arr.length - 1) {
            if (arr[i] > max) {
                max = arr[i];
            }

            // faith 1 to n-1 , will give max
            max = printArrJateHue(i + 1, arr, max);
        }
        return max;

    }

    public static int printArrVapasAteHue(int i, int[] arr, int max) {

        // ye vapas ate hue max nikala
        if (i <= arr.length - 1) {

            // faith 1 to n-1 , will give max
            max = printArrVapasAteHue(i + 1, arr, max);

            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;

    }
}