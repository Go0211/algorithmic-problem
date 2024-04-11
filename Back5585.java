package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val = 1000 - Integer.parseInt(br.readLine());
        int count = 0;

        while(val != 0) {
            if(val >= 500) {
                val -= 500;
                count++;
            } else if(val >= 100) {
                val -= 100;
                count++;
            } else if(val >= 50) {
                val -= 50;
                count++;
            } else if(val >= 10) {
                val -= 10;
                count++;
            } else if(val >= 5) {
                val -= 5;
                count++;
            } else if(val >= 1) {
                val -= 1;
                count++;
            }
        }

        System.out.println(count);
    }
}
