package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back17086 {
    static int[][] arr;
    static boolean[][] visited;

    static int[][] dirs = {{-1, 1},{0, 1},{1, 1},{-1, 0},{1, 0},{-1, -1},{0, -1},{1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int x = Integer.parseInt(strArr[0]);
        int y = Integer.parseInt(strArr[1]);
        arr = new int[x][y];

        for (int i = 0; i < x; i++) {
            int a;
            strArr = br.readLine().split(" ");
            for (int j = 0; j < strArr.length; j++) {
                a = Integer.parseInt(strArr[j]);
                if (a == 1) {
                    arr[i][j] = -1;
                } else {
                    arr[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == -1) {
                    bfs(i, j);
                }
            }
        }

        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != Integer.MAX_VALUE) {
                    max = Math.max(max, arr[i][j]);
                }
            }
        }

        System.out.println(max);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited = new boolean[arr.length][arr[0].length];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int idxX = val[0];
            int idxY = val[1];
            int count = val[2];

            for (int[] dir : dirs) {
                int nextX = dir[0] + idxX;
                int nextY = dir[1] + idxY;

                if (nextX >= 0 && nextY >= 0 && nextX < arr.length && nextY < arr[0].length) {
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY, count + 1});
                        arr[nextX][nextY] = Math.min(arr[nextX][nextY], count + 1);
                    }
                }
            }
        }
    }
}
