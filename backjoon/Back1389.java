package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Back1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int node = Integer.parseInt(strArr[0]);
        int seq = Integer.parseInt(strArr[1]);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < node + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < seq; i++) {
            strArr = br.readLine().split(" ");
            list.get(Integer.parseInt(strArr[0])).add(Integer.parseInt(strArr[1]));
            list.get(Integer.parseInt(strArr[1])).add(Integer.parseInt(strArr[0]));
        }

        int resultIdx = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < node + 1; i++) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{i, 1});
            boolean[] visited = new boolean[node + 1];
            visited[i] = true;

            int result = 0;

            while (!queue.isEmpty()) {
                int[] val = queue.remove();
                int idx = val[0];
                int count = val[1];
                result += count;

                for (int j = 0; j < list.get(idx).size(); j++) {
                    int nextIdx = list.get(idx).get(j);

                    if (!visited[nextIdx]) {
                        visited[nextIdx] = true;
                        queue.add(new int[]{nextIdx, count + 1});
                    }
                }
            }

            if (result < min) {
                resultIdx = i;
                min = result;
            }
        }

        System.out.println(resultIdx);
    }
}
