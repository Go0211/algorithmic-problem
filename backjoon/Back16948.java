package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back16948 {
    static int[][] dirs = {{-2, -1},{-2, 1},{0, -2},{0, 2},{2, -1},{2, 1}};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int startX = Integer.parseInt(strArr[0]);
        int startY = Integer.parseInt(strArr[1]);
        int endX = Integer.parseInt(strArr[2]);
        int endY = Integer.parseInt(strArr[3]);
        int[][] arr = new int[num][num];
        boolean[][] visited = new boolean[num][num];

        bfs(arr, visited, startX, startY, endX, endY);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void bfs(int[][] arr, boolean[][] visited, int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int idxX = val[0];
            int idxY = val[1];
            int count = val[2];

            if (idxX == endX && idxY == endY) {
                answer = Math.min(answer, count);
                break;
            }

            for (int[] dir : dirs) {
                int nextX = dir[0] + idxX;
                int nextY = dir[1] + idxY;

                if (nextX >= 0 && nextY >= 0 && nextX < arr.length && nextY < arr[0].length) {
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY, count + 1});
                    }
                }
            }
        }
    }
}
