package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        long a = Long.parseLong(strArr[0]);
        long b = Long.parseLong(strArr[1]);
        long c = Long.parseLong(strArr[2]);
        System.out.println(back1629(a, b, c));
    }

    public static long back1629(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }

        long z = back1629(a,  b / 2, c);

        if (b % 2 == 0) {
            return z * z % c;
        } else {
            return (z * z % c) * a % c;
        }
    }
}
