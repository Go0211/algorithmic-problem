package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num + 1];

        if (num >= 3) {
            arr[3] = 1;
        }
        if (num >= 5) {
            arr[5] = 1;
        }

        for (int i = 6; i < num + 1; i++) {
            if (i % 5 == 0) {
                arr[i] = arr[i - 5] + 1;
            } else if (i % 3 == 0) {
                arr[i] = arr[i - 3] + 1;
            } else {
                if (arr[i - 3] != 0 && arr[i - 5] != 0) {
                    arr[i] = Math.min(arr[i - 3], arr[i - 5]) + 1;
                }
            }
        }

        if (arr[num] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(arr[num]);
        }
    }
}
