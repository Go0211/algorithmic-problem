package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back1743 {
    static boolean[][] visited;
    static int[][] dirs = {{1, 0},{-1 ,0},{0, 1},{0, -1}};

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");

        int x = Integer.parseInt(strArr[0]) + 1;
        int y = Integer.parseInt(strArr[1]) + 1;
        int seq = Integer.parseInt(strArr[2]);
        boolean[][] arr = new boolean[x][y];
        visited = new boolean[x][y];

        for (int i = 0; i < seq; i++) {
            strArr = br.readLine().split(" ");
            arr[Integer.parseInt(strArr[0])][Integer.parseInt(strArr[1])] = true;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] && !visited[i][j]) {
                    bfs(arr, i, j);
                }
            }
        }

        System.out.println(result);
    }

    private static void bfs(boolean[][] arr, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int idxX = val[0];
            int idxY = val[1];

            for (int[] dir : dirs) {
                int nextX = dir[0] + idxX;
                int nextY = dir[1] + idxY;

                if (nextX >= 0 && nextX < arr.length && nextY >= 0 && nextY < arr[0].length) {
                    if (!visited[nextX][nextY] && arr[nextX][nextY]) {
                        count++;
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        result = Math.max(result, count);
    }
}
