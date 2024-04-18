package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1213 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[26];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            arr[(int)c - 65]++;
        }

        int checker = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                checker++;
            }
        }

        String[] strArr = new String[str.length()];

        if (checker >= 2) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            String front = "";
            String mid = "";
            String end = "";

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    for (int j = 0; j < arr[i]; j++) {
                        mid += (char)(i + 65);
                    }
                } else {
                    for (int j = 0; j < arr[i] / 2; j++) {
                        front += (char)(i + 65);
                    }
                }
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] % 2 == 0) {
                    for (int j = 0; j < arr[i] / 2; j++) {
                        end += (char)(i + 65);
                    }
                }
            }

            System.out.println(front+mid+end);
        }
    }
}
