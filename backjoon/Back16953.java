package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        long start = Long.parseLong(strArr[0]);
        long end = Long.parseLong(strArr[1]);

        System.out.println(bfs(start, end));
    }

    private static long bfs(long start, long end) {
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{start, 1});
        boolean[] visited = new boolean[(int) end + 1];
        visited[(int) start] = true;

        while (!queue.isEmpty()) {
            long[] val = queue.remove();
            long idx = val[0];
            long counts = val[1];

            if (idx == end) {
                return counts;
            }
            String s = String.valueOf(idx) + 1;
            if (Long.parseLong(s) <= end
                    && !visited[Integer.parseInt(s)]) {
                queue.add(new long[]{Long.parseLong(s), counts + 1});
                visited[Integer.parseInt(s)] = true;
            }
            if (idx * 2 <= end && !visited[(int) (idx * 2)]) {
                queue.add(new long[]{idx * 2, counts + 1});
                visited[(int) (idx * 2)] = true;
            }
        }


        return -1;
    }
}



