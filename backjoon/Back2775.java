package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[15][15];
        for (int j = 0; j < arr[0].length; j++) {
            arr[0][j] = j;
            arr[j][0] = 0;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        StringBuffer sb = new StringBuffer();
        int seq = Integer.parseInt(br.readLine());
        for (int i = 0; i < seq; i++) {
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            sb.append(arr[x][y] + "\n");
        }

        System.out.println(sb);
    }
}
