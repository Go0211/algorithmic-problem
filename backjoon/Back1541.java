package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] arr = str.split("");
        int idx = 0;

        boolean minus = false;
        int p = 0;
        int m = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("-") || arr[i].equals("+")) {
                String s = "";
                for (int j = idx; j < i; j++) {
                    s += arr[j];
                }

                int val = Integer.parseInt(s);

                if(minus) {
                    m += val;
                } else {
                    p += val;
                }

                idx = i + 1;

                if(arr[i].equals("-") && !minus) {
                    minus = true;
                }
            }
        }

        String s = "";
        for (int j = idx; j < arr.length; j++) {
            s += arr[j];
        }

        int val = Integer.parseInt(s);

        if(minus) {
            m += val;
        } else {
            p += val;
        }

        System.out.println(p - m);
    }
}
