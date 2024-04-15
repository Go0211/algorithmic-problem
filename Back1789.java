package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());

        long i = 1;
        int count = 0;
        while (num >= i) {
            count++;

            num -= i;

            i++;
        }

        System.out.println(count);
    }
}
