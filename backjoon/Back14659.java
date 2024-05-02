package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back14659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int[] arr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int a = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    a++;
                } else if (arr[i] == arr[j]){
                    continue;
                } else {
                    break;
                }
            }

            count = Math.max(a, count);
        }

        System.out.println(count);
    }
}
