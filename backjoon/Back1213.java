package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[27];
        for (int i = 0; i < str.length(); i++) {
            arr[(int) str.charAt(i) - 65]++;
        }

        int checker = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                checker++;
            }
        }

        String a = "";
        String b = "";
        String c = "";

        if (checker >= 2) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i] / 2; j++) {
                    a += (char) (i + 65);
                }

                for (int j = 0; j < arr[arr.length - (i + 1)] / 2; j++) {
                    c += (char) (arr.length - (i + 1) + 65);
                }

                if (arr[i] % 2 != 0) {
                    b += (char) (i + 65);
                }
            }

            System.out.println(a + b + c);
        }
    }
}
