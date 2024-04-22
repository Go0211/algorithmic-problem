package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back1246 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        int val = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int count = Integer.parseInt(strArr[0]);
        int seq = Integer.parseInt(strArr[1]);
        int[] arr = new int[seq];

        for (int i = 0; i < seq; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int limit = Math.min(arr.length - i, count);

            if (result < arr[i] * limit) {
                result = arr[i] * limit;
                val = arr[i];
            }
        }

        System.out.println(val + " " + result);
    }
}
