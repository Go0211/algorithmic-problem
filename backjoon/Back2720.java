package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int[] arr = new int[seq];
        int[] result = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuffer sb = new StringBuffer();

        for (int val : arr) {
            Arrays.fill(result, 0);

            while(val != 0) {
                if(val >= 25) {
                    val -= 25;
                    result[0]++;
                } else if(val >= 10) {
                    val -= 10;
                    result[1]++;
                } else if(val >= 5) {
                    val -= 5;
                    result[2]++;
                } else {
                    val -= 1;
                    result[3]++;
                }
            }

            for(int a : result) {
                sb.append(a + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
