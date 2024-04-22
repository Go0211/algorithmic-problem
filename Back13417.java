package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back13417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < seq; i++) {
            int len = Integer.parseInt(br.readLine());
            String answer = "";
            String[] strArr = br.readLine().split(" ");
            answer += strArr[0];
            for (int j = 1; j < strArr.length; j++) {
                if (answer.charAt(0) < strArr[j].charAt(0)) {
                    answer += strArr[j];
                } else {
                    answer = strArr[j].charAt(0) + answer;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
