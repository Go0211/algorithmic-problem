package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back1388 {
    static int[][] row = {{0, 1},{0, -1}};
    static int[][] col = {{1, 0},{-1, 0}};
    static int count = 0;
    static boolean[][] visited;
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int x = Integer.parseInt(strArr[0]);
        int y = Integer.parseInt(strArr[1]);
        arr = new String[x][y];
        visited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            strArr = br.readLine().split("");
            for (int j = 0; j < strArr.length; j++) {
                arr[i][j] = strArr[j];
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, arr[i][j]);
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int x, int y, String str) {
        int[][] dirs;
        if (str.equals("-")) {
            dirs = row;
        } else {
            dirs = col;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int xIdx = val[0];
            int yIdx = val[1];

            for (int[] dir : dirs) {
                int nextX = dir[0] + xIdx;
                int nextY = dir[1] + yIdx;

                if (nextX >= 0 && nextX < arr.length && nextY >= 0 && nextY < arr[0].length) {
                    if (!visited[nextX][nextY] && arr[nextX][nextY].equals(str)) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        count++;
    }
}
