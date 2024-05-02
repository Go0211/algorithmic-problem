package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Back2583 {
    static final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int x = Integer.parseInt(strArr[0]);
        int y = Integer.parseInt(strArr[1]);
        int seq = Integer.parseInt(strArr[2]);
        int[][] arr = new int[x][y];
        list = new ArrayList<>();

        for (int i = 0; i < seq; i++) {
            strArr = br.readLine().split(" ");
            int preX = Integer.parseInt(strArr[0]);
            int preY = Integer.parseInt(strArr[1]);
            int nextX = Integer.parseInt(strArr[2]);
            int nextY = Integer.parseInt(strArr[3]);

            for (int z = preY; z < nextY; z++) {
                for (int j = preX; j < nextX; j++) {
                    arr[z][j] = 1;
                }
            }
        }

        boolean[][] visited = new boolean[x][y];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    dfs(arr, i, j, visited);
                }
            }
        }

        System.out.println(list.size());
        list.sort((x1, x2) -> x1 - x2);
        for (int a : list) {
            System.out.print(a + " ");
        }
    }

    private static void dfs(int[][] arr, int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 1;

        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int xVal = val[0];
            int yVal = val[1];

            for (int[] dir : dirs) {
                int xNext = xVal + dir[0];
                int yNext = yVal + dir[1];

                if (xNext >= 0 && xNext < arr.length && yNext >= 0 && yNext < arr[0].length) {
                    if (arr[xNext][yNext] == 0 && !visited[xNext][yNext]) {
                        visited[xNext][yNext] = true;
                        queue.add(new int[]{xNext, yNext});
                        count++;
                    }
                }
            }
        }
        list.add(count);
    }
}
