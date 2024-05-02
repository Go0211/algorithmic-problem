package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int a = Integer.parseInt(strArr[0]);
        int len = Integer.parseInt(strArr[1]);
        String str = br.readLine();
        strArr = str.split("");
        int count = 0;

        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("H")) {
                for (int j = 1; j <= len; j++) {
                    if (i +j < strArr.length && strArr[i + j].equals("P")) {
                        strArr[i] = "x";
                        strArr[i + j] = "x";
                        count++;
                        break;
                    }
                }
            } else if (strArr[i].equals("P")) {
                for (int j = 1; j <= len; j++) {
                    if (i +j < strArr.length && strArr[i + j].equals("H")) {
                        strArr[i] = "x";
                        strArr[i + j] = "x";
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
