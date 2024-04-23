package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back9237 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int[] arr = new int[seq];
        int[] resultArr = new int[seq];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(arr);

        int days = 0;
        int answer = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int result = arr[i] + days + 1;
            answer = Math.max(result, answer);
            days++;
        }

        System.out.println(answer + 1);
    }
}
