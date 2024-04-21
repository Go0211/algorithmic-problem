package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Back2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int seq = Integer.parseInt(br.readLine());

        double[] arr = new double[seq];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(arr[i], arr[i] * arr[i - 1]);
        }

        Arrays.sort(arr);
        System.out.println(String.format("%.3f", arr[arr.length - 1]));
    }
}
