package algorithm_problem;

import javax.sql.rowset.BaseRowSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back11060 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        arr = new int[seq];
        String[] strArr = br.readLine().split(" ");
        for (int i = 0; i < seq; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        System.out.println(bfs(0));
    }

    private static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        boolean[] visited= new boolean[arr.length];

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int idx = val[0];
            int count = val[1];

            if (idx == arr.length - 1) {
                return count;
            }

            for (int i = 1; i <= arr[idx]; i++) {
                int nextIdx = idx + i;

                if (nextIdx < arr.length && !visited[nextIdx]) {
                    visited[nextIdx] = true;
                    queue.add(new int[]{nextIdx, count + 1});
                }
            }
        }

        return -1;
    }
}
