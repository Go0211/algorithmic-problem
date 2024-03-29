package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back9461 {
    //    2 ,4 -> 5
//    1, 5 - > 6
//    0, 6 -> 7
//    3, 7 -> 8
//    4, 8 -> 9
//    5, 9 -> 10
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());

        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        arr[6] = 3;
        arr[7] = 4;
        arr[8] = 5;

        for (int i = 9; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }

        for (int i = 0; i < seq; i++) {
            System.out.println(arr[Integer.parseInt(br.readLine())]);
        }
    }
}
