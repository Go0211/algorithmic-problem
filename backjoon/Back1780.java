package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1780 {
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

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
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    private static void quadTree(int[][] arr, int x, int y, int seq) {
        int check = arr[x][y];
        if (checker(arr, x, y, seq)) {
            if (check == -1) {
                minus++;
            } else if (check == 0) {
                zero++;
            } else {
                plus++;
            }
            return;
        }

        int newSize = seq / 3;
        for (int i = x; i < x + seq; i += newSize) {
            for (int j = y; j < y + seq; j += newSize) {
                quadTree(arr, i, j, newSize);
            }
        }
    }

    private static boolean checker(int[][] arr, int x, int y, int seq) {
        int check = arr[x][y];

        for (int i = x; i < x + seq; i++) {
            for (int j = y; j < y + seq; j++) {
                if (check != arr[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
