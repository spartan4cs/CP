public class Demo {

    public static int[] arrayFiller(int size, int digits) {
        int power = (int) Math.pow(10, digits);

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * power);
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
