package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Back1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        long[][] arr = new long[seq][2];

        for (int i = 0; i < seq; i++) {
            String[] strArr = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(strArr[0]);
            arr[i][1] = Integer.parseInt(strArr[1]);
        }

        Arrays.sort(arr, (x, y) -> (int) (x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]));

        int result = 1;
        long val = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
            if (val <= arr[i][0]) {
                result++;
                val = arr[i][1];
            }
        }

        System.out.println(result);
    }
}
