package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");

        int len = Integer.parseInt(strArr[0]);
        int start = Integer.parseInt(strArr[1]);
        int end = Integer.parseInt(strArr[2]);
        int up = Integer.parseInt(strArr[3]);
        int down = Integer.parseInt(strArr[4]);
        int result = Integer.MAX_VALUE;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        boolean[] visited = new boolean[len + 1];
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int idx = val[0];
            int count = val[1];

            if (idx == end) {
                result = Math.min(result, count);
            }

            if (idx + up <= len && !visited[idx + up]) {
                queue.add(new int[]{idx + up, count + 1});
                visited[idx + up] = true;
            }
            if (idx - down >= 1 && !visited[idx - down]) {
                queue.add(new int[]{idx  - down, count + 1});
                visited[idx - down] = true;
            }
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
        } else{
            System.out.println(result);
        }
    }
}
