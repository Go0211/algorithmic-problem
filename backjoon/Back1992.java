package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int[][] arr = new int[seq][seq];
        for (int i = 0; i < seq; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < strArr.length; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        quadTree(arr, 0, 0, seq);
    }

    private static void quadTree(int[][] arr, int x, int y, int size) {
        int newSize = size / 2;

        if (quadTreeCheck(arr, x, y, size)) {
            System.out.print(arr[x][y]);
            return;
        }

        System.out.print("(");
        quadTree(arr, x, y, newSize);
        quadTree(arr, x, y + newSize, newSize);
        quadTree(arr, x + newSize, y, newSize);
        quadTree(arr, x + newSize, y + newSize, newSize);
        System.out.print(")");
    }

    private static boolean quadTreeCheck(int[][] arr, int x, int y, int newSize) {
        int checker = arr[x][y];

        for (int i = x; i < x + newSize; i++) {
            for (int j = y; j < y + newSize; j++) {
                if (arr[i][j] != checker) {
                    return false;
                }
            }
        }

        return true;
    }
}
