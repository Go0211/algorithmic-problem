package algorithm_problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back15652 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sArr = br.readLine().split(" ");
        int n = Integer.parseInt(sArr[0]);
        int r = Integer.parseInt(sArr[1]);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        combination(arr, new int[r], 0, 0, n, r);
    }

    private static void combination(int[] arr, int[] out, int start, int depth, int n, int r) {
        if (depth == r) {
            for (int j : out) {
                System.out.print(j + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            out[depth] = arr[i];
            combination(arr, out, i, depth + 1, n, r);
        }
    }
}

