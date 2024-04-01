package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back14502 {
    static int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int x = Integer.parseInt(strArr[0]);
        int y = Integer.parseInt(strArr[1]);
        int[][] arr = new int[x][y];

        for (int i = 0; i < arr.length; i++) {
            strArr = br.readLine().split(" ");
            for (int j = 0; j < strArr.length; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        bfs(arr, 0);
        System.out.println(result);
    }

    private static void bfs(int[][] arr, int count) {
        int[][] arrClone = new int[arr.length][arr[0].length];

        for (int i = 0; i < arrClone.length; i++) {
            for (int j = 0; j < arrClone[0].length; j++) {
                arrClone[i][j] = arr[i][j];
            }
        }

        if (count == 3) {
            dfs(arrClone);
            return;
        }

        for (int i = 0; i < arrClone.length; i++) {
            for (int j = 0; j < arrClone[0].length; j++) {
                if (arrClone[i][j] == 0) {
                    arrClone[i][j] = 1;
                    bfs(arrClone, count + 1);
                    arrClone[i][j] = 0;
                }
            }
        }
    }

    private static void dfs(int[][] arrClone) {
        boolean[][] visited = new boolean[arrClone.length][arrClone[0].length];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < arrClone.length; i++) {
            for (int j = 0; j < arrClone[0].length; j++) {
                if (arrClone[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int x = val[0];
            int y = val[1];

            for (int[] dir : dirs) {
                int xNext = x + dir[0];
                int yNext = y + dir[1];

                if (xNext >= 0 && xNext < arrClone.length && yNext >= 0 && yNext < arrClone[0].length) {
                    if (arrClone[xNext][yNext] == 0 && !visited[xNext][yNext]) {
                        arrClone[xNext][yNext] = 2;
                        visited[xNext][yNext] = true;
                        queue.add(new int[]{xNext, yNext});
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < arrClone.length; i++) {
            for (int j = 0; j < arrClone[0].length; j++) {
                if (arrClone[i][j] == 0) {
                    count++;
                }
            }
        }

        result = Math.max(count, result);
    }
}
