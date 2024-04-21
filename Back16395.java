package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back16395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] arr = new long[30][30];

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }


        String[] strArr = br.readLine().split(" ");
        System.out.println(arr[Integer.parseInt(strArr[0]) - 1][Integer.parseInt(strArr[1]) - 1]);
    }
}
