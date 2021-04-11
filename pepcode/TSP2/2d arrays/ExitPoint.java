public class ExitPoint {

    // Approach 1
    public static void getExit(int[][] arr) {

        int r = arr.length;
        int c = arr[0].length;
        int dir = 0;
        int i = 0;
        int j = 0;
        while (i >= 0 && j >= 0 && i < r && j < c) {
            if (arr[i][j] == 0) {

                // same direction
                if (dir == 0) {
                    j++;// east
                } else if (dir == 1) {
                    i++;// south
                } else if (dir == 2) {
                    j--;// west
                } else if (dir == 3) {
                    i--;// north
                }

            } else if (arr[i][j] == 1) {

                // change direction

                if (dir == 0) {

                    dir = 1;

                    i++;
                } else if (dir == 1) {

                    dir = 2;
                    j--;
                } else if (dir == 2) {
                    dir = 3;

                    i--;
                } else if (dir == 3) {
                    dir = 0;
                    j++;
                }
            }

        }
        if (i == -1) {
            i++;
        } else if (j == -1) {
            j++;

        } else if (i == r) {
            i--;
        } else if (j == c) {
            j--;
        }
        System.out.println(i + " " + j);
    }

    // Approach2

    public static void getExit1(int[][] arr) {

        int r = arr.length;
        int c = arr[0].length;
        int dir = 0;
        int i = 0;
        int j = 0;
        while (i >= 0 && j >= 0 && i < r && j < c) {
            if (arr[i][j] == 1) {
                if (dir > 3) {
                    dir = 0;
                } else {
                    dir++;
                }
            }
            if (arr[i][j] == 0) {

                // same direction
                if (dir == 0) {
                    j++;// east
                } else if (dir == 1) {
                    i++;// south
                } else if (dir == 2) {
                    j--;// west
                } else if (dir == 3) {
                    i--;// north
                }

            }

        }
        if (i == -1) {
            i++;
        } else if (j == -1) {
            j++;

        } else if (i == r) {
            i--;
        } else if (j == c) {
            j--;
        }
        System.out.println(i + " " + j);
    }

    public static void main(String[] args) {
        int arr[][] = {

                { 0, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };
        // getExit(arr);
        getExit1(arr);
    }
}
