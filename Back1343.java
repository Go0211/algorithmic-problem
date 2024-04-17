package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        StringBuffer sb = new StringBuffer();
        boolean isMinus = false;

        a = a.replace("XXXX", "AAAA");
        a = a.replace("XX", "BB");

        if (a.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(a);
        }
    }
}
