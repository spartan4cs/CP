import java.util.Scanner;

public class CrossWordPuzzle {
    public static void solution(char[][] arr, String[] words, int vidx) {
        // write your code here
        if (vidx == words.length) {
            print(arr);
            return;
        }

        String word = words[vidx];
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[0].length; j++) {

                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {

                    if (canPlaceVertically(word, i, j, arr)) {

                        // place
                        boolean status[] = placeV(word, i, j, arr);
                        solution(arr, words, vidx + 1);
                        // unplace
                        unplaceV(word, i, j, arr, status);
                    }
                    if (canPlaceHorizontally(word, i, j, arr)) {

                        // place
                        boolean status[] = placeH(word, i, j, arr);
                        solution(arr, words, vidx + 1);
                        // unplace
                        unplaceH(word, i, j, arr, status);

                    }

                }
            }
        }

    }

    private static void unplaceH(String word, int i, int j, char[][] arr, boolean[] status) {

        for (int k = 0; k < status.length; k++) {
            if (status[k]) {
                arr[i][j + k] = '-';
            }
        }
    }

    private static boolean[] placeH(String word, int i, int j, char[][] arr) {
        boolean[] status = new boolean[word.length()];
        for (int k = 0; k < word.length(); k++) {
            if (arr[i][j + k] == '-') {

                arr[i][j + k] = word.charAt(k);
                status[k] = true;
            }
        }
        return status;
    }

    private static void unplaceV(String word, int i, int j, char[][] arr, boolean[] status) {

        for (int k = 0; k < status.length; k++) {
            if (status[k]) {
                arr[i + k][j] = '-';
            }
        }
    }

    private static boolean[] placeV(String word, int i, int j, char[][] arr) {

        boolean[] status = new boolean[word.length()];
        for (int k = 0; k < word.length(); k++) {
            if (arr[i + k][j] == '-') {

                arr[i + k][j] = word.charAt(k);
                status[k] = true;
            }
        }
        return status;
    }

    private static boolean canPlaceHorizontally(String word, int i, int j, char[][] arr) {

        // cheeck lenght of word matches arr - horizontally

        // leftcheck & right cehck
        if ((j > 0 && arr[i][j - 1] != '+') || j + word.length() - 1 >= arr[0].length)
            return false;

        // less space or moore space or wall
        if (j + word.length() - 1 < arr[0].length - 1 && arr[i][j + word.length()] != '+') {
            return false;
        }

        // if empty space with perfect fit, then no problem
        // if letters filled then should match with word
        for (int k = 0; k < word.length(); k++) {
            char ch = word.charAt(k);
            if (arr[i][j + k] != '-' && arr[i][j + k] != ch) {
                return false;
            }
        }

        return true;
    }

    private static boolean canPlaceVertically(String word, int i, int j, char[][] arr) {

        // cheeck lenght of word matches arr - horizontally

        // top &bottom cehck
        if ((i > 0 && arr[i - 1][j] != '+') || i + word.length() - 1 >= arr.length)
            return false;

        // less space or moore space or wall
        if (i + word.length() - 1 < arr.length - 1 && arr[i + word.length()][j] != '+') {
            return false;
        }

        // if empty space with perfect fit, then no problem
        // if letters filled then should match with word
        for (int k = 0; k < word.length(); k++) {
            char ch = word.charAt(k);
            if (arr[i + k][j] != '-' && arr[i + k][j] != ch) {
                return false;
            }
        }

        return true;
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        solution(arr, words, 0);
    }
}
