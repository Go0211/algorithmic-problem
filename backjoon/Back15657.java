package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back15657 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int r = Integer.parseInt(strArr[1]);
        int[] arr = new int[n];

        strArr = br.readLine().split(" ");
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(arr);

        combination(arr, new int[r], 0, 0, n, r);
    }

    private static void combination(int[] arr, int[] outs, int start, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < outs.length; i++) {
                System.out.print(outs[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            outs[depth] = arr[i];
            combination(arr, outs, i, depth + 1, n , r);
        }
    }
}
