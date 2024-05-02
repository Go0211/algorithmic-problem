package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Back1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        long a = 1;
        long b = 2;

        if (len == 1) {
            System.out.println(a);
        } else if (len == 2){
            System.out.println(b);
        } else {
            for (int i = 2; i < len; i++) {
                long c = a + b;
                a = b % 15746;
                b = c % 15746;
            }

            System.out.println(b);
        }
    }
}
