package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int[] arr = new int[seq];
        for (int i = 0; i < seq; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int count = 1;
        long total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += Math.abs(arr[i] - count);
            count++;
        }

        System.out.println(total);
    }
}
