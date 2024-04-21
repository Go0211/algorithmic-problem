package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int[] arr = new int[seq];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        int start = arr[0];
        int min = 1;
        int max = 1;
        int result = 0;

        for (int i = 1; i < arr.length; i++) {
            if (start == arr[i]) {
                min++;
                max++;
            } else if (start < arr[i]){
                max++;
                result = Math.max(result, min);
                min = 1;
            } else {
                min++;
                result = Math.max(result, max);
                max = 1;
            }

            start = arr[i];
        }

        result = Math.max(result, Math.max(min, max));
        System.out.println(result);
    }
}
