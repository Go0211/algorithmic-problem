package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Back1012 {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        ArrayList<int[][]> arrayList = new ArrayList<>();

        for (int i = 0; i < testCount; i++) {
            String[] strArr = br.readLine().split(" ");
            arrayList.add(new int[Integer.parseInt(strArr[0])][Integer.parseInt(strArr[1])]);
            int[][] arr = arrayList.get(i);
            int seq = Integer.parseInt(strArr[2]);

            for (int j = 0; j < seq; j++) {
                strArr = br.readLine().split(" ");
                arr[Integer.parseInt(strArr[0])][Integer.parseInt(strArr[1])] = 1;
            }
        }

        for (int k = 0; k < arrayList.size(); k++) {
            int[][] arr = arrayList.get(k);
            boolean[][] visited = new boolean[arr.length][arr[0].length];
            int count = 0;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        bfs(arr, visited, i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void bfs(int[][] arr, boolean[][] visited, int x, int y) {
        for (int[] dir : dirs) {
            int xNext = x + dir[0];
            int yNext = y + dir[1];

            if (xNext >= 0 && xNext < arr.length && yNext >= 0 && yNext < arr[0].length) {
                if (arr[xNext][yNext] == 1 && !visited[xNext][yNext]) {
                    visited[xNext][yNext] = true;
                    bfs(arr, visited, xNext, yNext);
                }
            }
        }
    }
}
