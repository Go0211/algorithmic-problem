package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int myVote = Integer.parseInt(br.readLine());
        int[] arr = new int[num - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        while (true) {
            Arrays.sort(arr);
            if (num == 1) {
                break;
            } else if (myVote <= arr[arr.length - 1]) {
                myVote++;
                arr[arr.length - 1]--;
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}
