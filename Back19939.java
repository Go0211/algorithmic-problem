package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back19939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int num = Integer.parseInt(strArr[0]);
        int basket = Integer.parseInt(strArr[1]);
        int[] arr = new int[basket];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 + i;
            num -= 1 + i;
        }

        if (num >= 0) {
            while (num != 0) {
                for (int i = arr.length - 1; i >= 0; i--) {
                    if (num > 0) {
                        arr[i]++;
                        num--;
                    } else {
                        break;
                    }
                }
            }

            System.out.println(arr[arr.length - 1] - arr[0]);
        } else {
            System.out.println(-1);
        }
    }
}
