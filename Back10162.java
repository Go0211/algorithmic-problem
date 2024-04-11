package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val = Integer.parseInt(br.readLine());
        int[] arr = new int[3];

        if(val % 10 != 0) {
            System.out.println(-1);
        } else {
            while (val != 0) {
                if(val >= 300) {
                    val -= 300;
                    arr[0]++;
                } else if(val >= 60) {
                    val -= 60;
                    arr[1]++;
                } else {
                    val -= 10;
                    arr[2]++;
                }
            }

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
