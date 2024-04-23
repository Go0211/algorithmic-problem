package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.BreakIterator;
import java.util.Arrays;

public class Back16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int seq = Integer.parseInt(strArr[0]);
        int len = Integer.parseInt(strArr[1]);

        strArr = br.readLine().split(" ");
        int[] arr = new int[seq];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (len >= arr[i]) {
                len++;
            } else {
                break;
            }
        }

        System.out.println(len);
    }
}
