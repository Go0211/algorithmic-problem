package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back9625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] a = new int[46];
        int[] b = new int[46];
        a[0] = 1;
        b[1] = 1;
        a[2] = 1;
        b[2] = 1;
        a[3] = 1;
        b[3] = 2;

        for (int i = 4; i < 46; i++) {
            a[i] = a[i - 1] + a[i - 2];
            b[i] = b[i - 1] + b[i - 2];
        }

        System.out.println(a[num] + " " + b[num]);
    }
}
