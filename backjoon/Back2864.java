package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        String minA = strArr[0];
        String minB = strArr[1];
        String maxA = strArr[0];
        String maxB = strArr[1];

        minA = minA.replace("6", "5");
        minB = minB.replace("6", "5");
        maxA = maxA.replace("5", "6");
        maxB = maxB.replace("5", "6");

        int min = Integer.parseInt(minA) + Integer.parseInt(minB);
        int max = Integer.parseInt(maxA) + Integer.parseInt(maxB);

        System.out.println(min + " " + max);
    }
}
