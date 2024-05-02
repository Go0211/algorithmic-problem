package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        long[] dp = new long[91];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < dp.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                dp[i] += dp[j];
            }
        }

        System.out.println(dp[num]);

//        1 -> 1
//        2 -> 10
//        3 -> 100, 101
//        4 -> 1000, 1001, 1010
//        5 -> 10000, 10101, 10100, 10001, 10010
    }
}
