package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int seq = Integer.parseInt(strArr[0]);
        int len = Integer.parseInt(strArr[1]);
        String[] arr = new String[seq];
        int[] idxArr;
        String str = "";
        int total = 0;

        for (int i = 0; i < seq; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < len; i++) {
            idxArr = new int[26];
            int idx = 0;

            for (int j = 0; j < arr.length; j++) {
                idxArr[arr[j].charAt(i) - 65]++;
            }

            for (int j = 1; j < idxArr.length; j++) {
                if (idxArr[idx] < idxArr[j]) {
                    total += idxArr[idx];
                    idx = j;
                    continue;
                }
                total += idxArr[j];
            }

            str += (char)(idx + 65);
        }

        System.out.println(str);
        System.out.println(total);
    }
}
