public class BaseCountSort {

    public static void baseCountSort(int[] arr, int max_range) {
        int freqMap[] = generateFreqMap(arr, max_range);
        int index = 0;
        for (int i = 0; i < freqMap.length; i++) {
            int val = i;
            int fq = freqMap[i];

            for (int j = 0; j < fq; j++) {
                arr[index] = val;
                index++;
            }

        }

        display(arr);

    }

    public static void display(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static int[] generateFreqMap(int[] arr, int max_range) {
        int[] freqMap = new int[max_range + 1];

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            freqMap[val]++;
        }
        return freqMap;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 3, 3, 3, 4, 4, 4, 9, 9, 9, 7, 7, 7, 6, 6, 6 };
        int max_range = 9;
        baseCountSort(arr, max_range);
    }
}
