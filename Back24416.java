package algorithm_problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back24416 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val = Integer.parseInt(br.readLine());

        System.out.println(fib(val) + " " + fibonacci(val));
    }

    private static int fibonacci(int val) {
        int count = 0;

        int[] f = new int[val + 1];
        f[1] = f[2] = 1;

        for (int i = 3; i <= val; i++) {
            f[i] = f[i - 1] + f[i - 2];
            count++;
        }

        return count;
    }

    private static int fib(int val) {
        if (val == 1 || val == 2) {
            return 1;
        } else {
            return (fib(val - 1) + fib(val - 2));
        }
    }
}
