package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back10974 {
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        per(arr, new int[num], new boolean[num], 0, arr.length, arr.length);
        System.out.println(sb);
    }

    private static void per(int[] arr, int[] out, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < out.length; i++) {
                sb.append(out[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                per(arr, out, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
