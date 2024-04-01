package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int start = Integer.parseInt(strArr[0]);
        int end = Integer.parseInt(strArr[1]);

        System.out.println(bfs(start, end, 0));
    }

    private static int bfs(int start, int end, int count) {
        int result = Integer.MAX_VALUE;

        boolean[] visited = new boolean[100_001];
        visited[start] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, count});

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int startVal = val[0];
            int countVal = val[1];
            visited[startVal] = true;

            if (startVal == end) {
                result = Math.min(result, countVal);
                visited[end] = false;
                continue;
            }

            if (startVal + 1 < visited.length && !visited[startVal + 1]) {
                queue.add(new int[]{startVal + 1, countVal + 1});
            }
            if (startVal - 1 >= 0 && !visited[startVal - 1]) {
                queue.add(new int[]{startVal - 1, countVal + 1});
            }
            if (startVal * 2 < visited.length && !visited[startVal * 2]) {
                queue.add(new int[]{startVal * 2, countVal});
            }
        }

        return result;
    }
}
