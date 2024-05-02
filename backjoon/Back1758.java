package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int[] arr = new int[seq];

        for (int i = 0; i < seq; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long result = 0;
        int count = 0;
        for (int i = arr.length - 1;  i >= 0; i--) {
            if (arr[i] - count > 0) {
                result += arr[i] - count;
            }

            count++;
        }

        System.out.println(result);
    }
}
