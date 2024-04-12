package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back3184 {
    static int wolf = 0;
    static int sheep = 0;
    static String[][] arr;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

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
                if ((arr[i][j].equals("v") || arr[i][j].equals("o")) && !visited[i][j]) {
                    bfs(i, j, arr[i][j]);
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    private static void bfs(int x, int y, String animal) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int w = 0;
        int s = 0;

        if (animal.equals("o")) {
            s++;
        } else {
            w++;
        }

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int xIdx = val[0];
            int yIdx = val[1];

            for (int[] dir : dirs) {
                int nextX = dir[0] + xIdx;
                int nextY = dir[1] + yIdx;

                if (nextX >= 0 && nextX < arr.length && nextY >= 0 && nextY < arr[0].length) {
                    if (!arr[nextX][nextY].equals("#") && !visited[nextX][nextY]) {
                        if (arr[nextX][nextY].equals("o")) {
                            s++;
                        } else if (arr[nextX][nextY].equals("v")) {
                            w++;
                        }
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        if (s > w) {
            sheep += s;
        } else {
            wolf += w;
        }
    }
}
