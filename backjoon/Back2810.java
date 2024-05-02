package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String cupHolder = "";

        for (int i = 0; i < str.split("").length; i++) {
            if (str.split("")[i].equals("S")) {
                cupHolder += "*S";
            } else {
                cupHolder += "*LL";
                i++;
            }
        }

        cupHolder += "*";

        int count = 0;
        for (String s : cupHolder.split("")) {
            if(s.equals("*")) {
                count++;
            }
        }

        count = Math.min(count, seq);
        System.out.println(count);
    }
}
