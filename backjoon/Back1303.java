package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back1303 {
    static String[][] arr;
    static int blue = 0;
    static int white = 0;
    static boolean[][] visited;
    static int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int y = Integer.parseInt(strArr[0]);
        int x = Integer.parseInt(strArr[1]);
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
                    bfs(i, j, arr[i][j]);
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    private static void bfs(int x, int y, String str) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int xIdx = val[0];
            int yIdx = val[1];

            for (int[] dir : dirs) {
                int nextX = dir[0] + xIdx;
                int nextY = dir[1] + yIdx;

                if (nextX >= 0 && nextX < arr.length && nextY >= 0 && nextY < arr[0].length) {
                    if (!visited[nextX][nextY] && arr[nextX][nextY].equals(str)) {
                        count++;
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        if (str.equals("W")) {
            white += Math.pow(count, 2);
        } else {
            blue += Math.pow(count, 2);
        }
    }
}
