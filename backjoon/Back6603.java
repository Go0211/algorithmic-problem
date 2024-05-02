package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr;
        while (true) {
            strArr = br.readLine().split(" ");
            if (strArr[0].equals("0")) {
                break;
            }
            int seq = Integer.parseInt(strArr[0]);
            int[] arr = new int[seq];

            for (int i = 0; i < seq; i++) {
                arr[i] = Integer.parseInt(strArr[i + 1]);
            }

            Arrays.sort(arr);

            combination(arr, new boolean[arr.length], 0, 0, seq, 6);
            System.out.println();
        }
    }

    private static void combination(int[] arr, boolean[] visited, int start, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(arr, visited, i+1, depth + 1, n ,r);
                visited[i] = false;
            }
        }
    }
}
