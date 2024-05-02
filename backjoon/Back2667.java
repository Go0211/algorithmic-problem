package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Back2667 {
    static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static ArrayList<Integer> arrayList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int[][] arr = new int[seq][seq];
        boolean[][] visited = new boolean[seq][seq];
        arrayList = new ArrayList<>();

        for (int i = 0; i < seq; i++) {
            String[] sArr = br.readLine().split("");
            for (int j = 0; j < sArr.length; j++) {
                arr[i][j] = Integer.parseInt(sArr[j]);
            }
        }

        for (int i = 0; i < seq; i++) {
            for (int j = 0; j < seq; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    bfs(arr, i, j, visited);
                }
            }
        }

        Collections.sort(arrayList);
        System.out.println(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    private static void bfs(int[][] arr, int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;

        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int xIdx = val[0];
            int yIdx = val[1];

            for (int[] dir : dirs) {
                int xNext = dir[0] + xIdx;
                int yNext = dir[1] + yIdx;

                if (xNext >= 0 && xNext < arr.length && yNext >= 0 && yNext < arr[0].length) {
                    if (arr[xNext][yNext] == 1 && !visited[xNext][yNext]) {
                        queue.add(new int[]{xNext, yNext});
                        visited[xNext][yNext] = true;
                        count++;
                    }
                }
            }
        }

        arrayList.add(count + 1);
    }
}
