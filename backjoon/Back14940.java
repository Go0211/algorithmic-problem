package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back14940 {
    static int[][] totalArr;
    static int[][] dirs = {{1, 0},{-1, 0},{0, -1},{0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int x = Integer.parseInt(strArr[0]);
        int y = Integer.parseInt(strArr[1]);
        int[][] arr = new int[x][y];
        totalArr = new int[x][y];
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < x; i++) {
            strArr = br.readLine().split(" ");
            for (int j = 0; j < strArr.length; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
                if (arr[i][j] == 0) {
                    totalArr[i][j] = 0;
                } else {
                    totalArr[i][j] = -1;
                }
            }
        }

        boolean finish = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 2) {
                    finish = bfs(arr, i, j);
                    break;
                }
            }
            if (finish) {
                break;
            }
        }

        for (int i = 0; i < totalArr.length; i++) {
            for (int j = 0; j < totalArr[0].length; j++) {
                sb.append(totalArr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean bfs(int[][] arr, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        totalArr[x][y] = 0;
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int idxX = val[0];
            int idxY = val[1];
            int count = val[2];

            for (int[] dir : dirs) {
                int nextX = dir[0] + idxX;
                int nextY = dir[1] + idxY;

                if (nextX >= 0 && nextX < arr.length && nextY >= 0 && nextY < arr[0].length) {
                    if (!visited[nextX][nextY] && arr[nextX][nextY] != 0) {
                        totalArr[nextX][nextY] = count + 1;
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY, count + 1});
                    }
                }
            }
        }

        return true;
    }
}
