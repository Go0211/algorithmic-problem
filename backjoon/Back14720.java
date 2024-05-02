package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back14720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");

        int before = 2;
        int count = 0;

        for (String s : strArr) {
            int val = Integer.parseInt(s);

            if (before == 2 && val == 0) {
                count++;
                before = val;
            } else if (before == 0 && val == 1) {
                count++;
                before = val;
            } else if (before == 1 && val == 2) {
                count++;
                before = val;
            }
        }

        System.out.println(count);
    }
}
