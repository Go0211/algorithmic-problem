package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back4963 {
    static int[][] dirs = {{1, 1},{1, 0},{1, -1},{0, 1},{0, -1},{-1 , 1},{-1, 0},{-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        while (true) {
            String[] strArr = br.readLine().split(" ");
            int y = Integer.parseInt(strArr[0]);
            int x = Integer.parseInt(strArr[1]);

            if (x == 0 && y == 0) {
                break;
            }

            int[][] arr = new int[x][y];
            boolean[][] visited = new boolean[x][y];
            int count = 0;

            for (int i = 0; i < x; i++) {
                strArr = br.readLine().split(" ");
                for (int j = 0; j < strArr.length; j++) {
                    arr[i][j] = Integer.parseInt(strArr[j]);
                }
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        bfs(arr, visited, i, j);
                        count++;
                    }
                }
            }

            sb.append(count+"\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int[][] arr, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] val = queue.remove();

            for (int[] dir : dirs) {
                int xNext = dir[0] + val[0];
                int yNext = dir[1] + val[1];

                if (xNext >= 0 && xNext < arr.length && yNext >= 0 && yNext < arr[0].length) {
                    if (arr[xNext][yNext] == 1 && !visited[xNext][yNext]) {
                        queue.add(new int[]{xNext, yNext});
                        visited[xNext][yNext] = true;
                    }
                }
            }
        }
    }
}
