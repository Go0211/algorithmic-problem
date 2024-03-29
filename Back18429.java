package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back18429 {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int less = Integer.parseInt(strArr[1]);
        strArr = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        permutation(arr, new boolean[n], 0, n, less, 500);
        System.out.println(result);
    }

    private static void permutation(int[] arr, boolean[] visited, int depth, int n, int less, int limit) {
        if (depth == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && limit - less + arr[i] >= 500) {
                visited[i] = true;
                permutation(arr, visited, depth + 1, n, less, limit - less + arr[i]);
                visited[i] = false;
            }
        }
    }
}
