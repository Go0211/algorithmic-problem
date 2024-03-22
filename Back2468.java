package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2468 {
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int[][] arr = new int[seq][seq];
        int max = 0;

        for (int i = 0; i < seq; i++) {
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < strArr.length; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
                max = Math.max(arr[i][j], max);
            }
        }

        int answer = 0;
        for (int k = 1; k <= max; k++) {
            boolean[][] visited = new boolean[seq][seq];
            int result = 0;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] >= k && !visited[i][j]) {
                        bfs(arr, visited, i, j, k);
                        result++;
                    }
                }
            }

            answer = Math.max(answer, result);
        }

        System.out.println(answer);
    }

    private static void bfs(int[][] arr, boolean[][] visited, int x, int y, int k) {
        for (int[] dir : dirs) {
            int xNext = x + dir[0];
            int yNext = y + dir[1];

            if (xNext >= 0 && xNext < arr.length && yNext >= 0 && yNext < arr[0].length) {
                if (!visited[xNext][yNext] && arr[xNext][yNext] >= k) {
                    visited[xNext][yNext] = true;
                    bfs(arr, visited, xNext, yNext, k);
                }
            }
        }
    }
}
