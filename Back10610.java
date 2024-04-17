package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Back10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split("");
        boolean isTrue = false;
        StringBuffer sb = new StringBuffer();

        Arrays.sort(strArr);
        for (int i = 0; i < strArr.length / 2; i++) {
            String a = strArr[i];
            strArr[i] = strArr[strArr.length - (i + 1)];
            strArr[strArr.length - (i + 1)] = a;
        }

        if (strArr[strArr.length - 1].equals("0")) {
            int a = 0;
            for (String s : strArr) {
                a += Integer.parseInt(s);
            }

            if (a % 3 == 0) {
                for (String s : strArr) {
                    sb.append(s);
                }
                isTrue = true;
            }
        }

        if (isTrue) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}
