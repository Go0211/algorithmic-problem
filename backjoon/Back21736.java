package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Back21736 {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int x = Integer.parseInt(strArr[0]);
        int y = Integer.parseInt(strArr[1]);
        String[][] arr = new String[x][y];
        int ix = 0;
        int iy = 0;

        for (int i = 0; i < x; i++) {
            strArr = br.readLine().split("");
            for (int j = 0; j < strArr.length; j++) {
                arr[i][j] = strArr[j];
                if (arr[i][j].equals("I")) {
                    ix = i;
                    iy = j;
                }
            }
        }

//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ix, iy});
        boolean[][] visited = new boolean[x][y];
        visited[ix][iy] = true;

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int valX = val[0];
            int valY = val[1];

            for (int[] dir : dirs) {
                int nextX = valX + dir[0];
                int nextY = valY + dir[1];

                if (nextX >= 0 && nextX < x && nextY >= 0 && nextY < y) {
                    if (!visited[nextX][nextY] && !arr[nextX][nextY].equals("X")) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        if (arr[nextX][nextY].equals("P")) {
                            count++;
                        }
                    }
                }
            }
        }

        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }
}
