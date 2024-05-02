package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int start = Integer.parseInt(strArr[0]);
        int end = Integer.parseInt(strArr[1]);

        System.out.println(bfs(start, end, 0));
    }

    private static int bfs(int start, int end, int count) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, count});
        boolean[] visible = new boolean[100001];
        visible[start] = true;

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int idx = val[0];
            int counts = val[1];

            if (idx == end) {
                return counts;
            }

            if (idx * 2 <= 100000 && idx >= 0 && !visible[idx * 2]) {
                visible[idx * 2] = true;
                queue.add(new int[]{idx * 2, counts + 1});
            }
            if (idx + 1 <= 100000 && !visible[idx + 1]) {
                visible[idx + 1] = true;
                queue.add(new int[]{idx + 1, counts + 1});
            }
            if (idx - 1 >= 0 && !visible[idx - 1]) {
                visible[idx - 1] = true;
                queue.add(new int[]{idx - 1, counts + 1});
            }
        }
        return -1;
    }
}
