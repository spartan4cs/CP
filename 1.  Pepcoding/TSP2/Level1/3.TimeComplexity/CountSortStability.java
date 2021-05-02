import java.util.Arrays;

public class CountSortStability {

    public static int[] generateFreqMap(int[] arr, int min, int max) {
        int[] freqMap = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i] - min;
            freqMap[val]++;
        }
        return freqMap;
    }

    public static int[] generatePrefixMap(int[] fmap) {
        fmap[0]--;

        for (int i = 1; i < fmap.length; i++) {
            fmap[i] += fmap[i - 1];
        }
        return fmap;
    }

    public static int[] fillArrFromReverse(int[] arr, int min, int max, int[] fmap) {
        int narr[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            int val = arr[i];
            // index of fmap
            int index = val - min;

            // pos where we need to place new arr
            int pos = fmap[index];

            // place it
            narr[pos] = val;

            // reduce the freq
            fmap[index]--;

        }

        return narr;
    }

    public static void stableCountSort(int[] arr, int min, int max) {
        // generate prefixmap
        int freqMap[] = generateFreqMap(arr, min, max);

        // generate prefix sum
        freqMap = generatePrefixMap(freqMap);

        // fill the arr

        arr = fillArrFromReverse(arr, min, max, freqMap);

        display(arr);

    }

    public static void display(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 3, 3, 3, 4, 4, 4, 9, 9, 9, 7, 7, 7, 6, 6, 6 };

        stableCountSort(arr, 1, 9);
    }
}
