package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int screen = Integer.parseInt(strArr[0]);
        int basket = Integer.parseInt(strArr[1]);
        int seq = Integer.parseInt(br.readLine());
        int start = 1;
        int end = basket;
        int[] arr = new int[seq];
        for (int i = 0; i < seq; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < start) {
                while (arr[i] < start) {
                    start--;
                    end--;
                    count++;
                }
            } else if (arr[i] > end) {
                while (arr[i] > end) {
                    start++;
                    end++;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
