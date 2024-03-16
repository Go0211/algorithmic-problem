package algorithm_problem;

import main.Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back15654 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        int n = Integer.parseInt(str1[0]);
        int r = Integer.parseInt(str1[1]);
        int[] arr = new int[n];

        String[] inputStr = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputStr[i]);
        }
        Arrays.sort(arr);

        Back15654 m = new Back15654();
        m.permutation(arr, new int[r], new boolean[n], 0, n, r);
    }

    private void permutation(int[] arr, int[] out, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            for (int i : out) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
