package algorithm_problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back15656 {
    static StringBuffer sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        String[] strArr = br.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int r = Integer.parseInt(strArr[1]);

        int[] arr = new int[n];
        strArr = br.readLine().split(" ");
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(arr);

        permutation(arr, new int[r], 0, n ,r);

        System.out.println(sb);
    }

    private static void permutation(int[] arr, int[] outs, int depth, int n, int r) {
        if (depth == r) {
            for (int a : outs) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            outs[depth] = arr[i];
            permutation(arr, outs, depth + 1, n ,r);
        }
    }
}
