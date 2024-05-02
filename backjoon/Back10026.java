package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Back10026 {
    /*
     * R, G ,B -> 일반인
     * R = G , B -> 적록색약
     * 각 구역의 수를 구하라
     * 일반인 적록색약
     *
     * */

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        String[][] arr = new String[seq][seq];
        String[][] rgArr = new String[seq][seq];

        for (int i = 0; i < seq; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < strArr.length; j++) {
                arr[i][j] = strArr[j];
                if (strArr[j].equals("G")) {
                    rgArr[i][j] = "R";
                } else {
                    rgArr[i][j] = strArr[j];
                }
            }
        }

        int count1 = 0;
        boolean[][] visited = new boolean[seq][seq];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (!visited[i][j]) {
                    bfs(arr, visited, i, j);
                    count1++;
                }
            }
        }

        int count2 = 0;
        visited = new boolean[seq][seq];
        for (int i = 0; i < rgArr.length; i++) {
            for (int j = 0; j < rgArr[0].length; j++) {
                if (!visited[i][j]) {
                    bfs(rgArr, visited, i, j);
                    count2++;
                }
            }
        }
        bfs(rgArr, visited, 0, 0);

        System.out.println(count1 + " " + count2);
    }

    private static void bfs(String[][] arr, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            for (int[] dir : dirs) {
                int xNext = val[0] + dir[0];
                int yNext = val[1] + dir[1];

                if (xNext >= 0 && xNext < arr.length && yNext >= 0 && yNext < arr[0].length) {
                    if (!visited[xNext][yNext] && arr[xNext][yNext].equals(arr[x][y])) {
                        queue.add(new int[]{xNext, yNext});
                        visited[xNext][yNext] = true;
                    }
                }
            }
        }
    }
}
