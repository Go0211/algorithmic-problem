package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back16922 {
    static int[] arr = {1, 5, 10, 50};
    static int result = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputs = Integer.parseInt(br.readLine());
        visited = new boolean[50*inputs + 1];

        combination(0, 0, arr.length, inputs, 0);

        System.out.println(result);
    }

    private static void combination(int start, int depth, int n, int r, int val) {
        if(depth == r) {
            if (!visited[val]) {
                visited[val] = true;
                result++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            val += arr[i];
            combination(i, depth + 1, n, r, val);
            val -= arr[i];
        }
    }
}
