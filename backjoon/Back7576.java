package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back7576 {
    static int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int xLen = Integer.parseInt(strArr[1]);
        int yLen = Integer.parseInt(strArr[0]);
        int[][] arr = new int[xLen][yLen];

        for (int i = 0; i < xLen; i++) {
            strArr = br.readLine().split(" ");
            for (int j = 0; j < strArr.length; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        System.out.println(bfs(arr, new boolean[arr.length][arr[0].length]));
    }

    private static int bfs(int[][] arr, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int result = 0;

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int x = val[0];
            int y = val[1];
            int count = val[2];

            for (int[] dir : dirs) {
                int xNext = x + dir[0];
                int yNext = y + dir[1];

                if (xNext >= 0 && xNext < arr.length && yNext >= 0 && yNext < arr[0].length) {
                    if (!visited[xNext][yNext] && arr[xNext][yNext] != -1) {
                        arr[xNext][yNext] = 1;
                        visited[xNext][yNext] = true;
                        queue.add(new int[]{xNext, yNext, count + 1});
                    }
                }
            }

            result = Math.max(result, count);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    return -1;
                }
            }
        }

        return result;
    }
}
