package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num + 1];

        if (num >= 2) {
            arr[2] = 1;
        }
        if (num >= 4) {
            arr[4] = 2;
        }
        if (num >= 5) {
            arr[5] = 1;
        }

        for (int i = 6; i < num + 1; i++) {
            if (i % 5 == 0) {
                arr[i] = arr[i - 5] + 1;
            } else if (i % 2 == 0) {
                arr[i] = arr[i - 2] + 1;
            } else {
                if (arr[i - 2] != 0 && arr[i - 5] != 0) {
                    arr[i] = Math.min(arr[i - 2], arr[i - 5]) + 1;
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
