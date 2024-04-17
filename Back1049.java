package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int need = Integer.parseInt(strArr[0]);
        int seq = Integer.parseInt(strArr[1]);

        int[] six = new int[seq];
        int[] one = new int[seq];
        for (int i = 0; i < seq; i++) {
            strArr = br.readLine().split(" ");
            six[i] = Integer.parseInt(strArr[0]);
            one[i] = Integer.parseInt(strArr[1]);
        }

        Arrays.sort(six);
        Arrays.sort(one);
        int result = 0;

        while (true) {
            if (need >= 6) {
                if (six[0] < one[0] * 6) {
                    result += six[0];
                    need -= 6;
                } else {
                    result = one[0] * need;
                    break;
                }
            } else {
                if (six[0] < one[0] * need) {
                    result += six[0];
                } else {
                    result += one[0] * need;
                }
                break;
            }
        }

        System.out.println(result);
    }
}
