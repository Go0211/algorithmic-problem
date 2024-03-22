package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2630 {
    static int zero = 0;
    static int one = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int[][] arr = new int[seq][seq];
        for (int i = 0; i < seq; i++) {
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < strArr.length; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        quadTree(arr, 0, 0, seq);

        System.out.println(zero);
        System.out.println(one);
    }

    private static void quadTree(int[][] arr, int x, int y, int size) {
        int newSize = size / 2;

        if (!checkArr(arr, arr[x][y], x, y, size)) {
            if (arr[x][y] == 0) {
                zero++;
            } else {
                one++;
            }

            return;
        }

        quadTree(arr, x, y, newSize);
        quadTree(arr, x, y + newSize, newSize);
        quadTree(arr, x + newSize, y, newSize);
        quadTree(arr, x + newSize, y + newSize, newSize);
    }

    private static boolean checkArr(int[][] arr, int val, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (val != arr[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }
}
