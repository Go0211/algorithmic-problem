package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back7562 {
    static int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        int seq = Integer.parseInt(br.readLine());
        String[] strArr;
        boolean[][] visited;

        for (int i = 0; i < seq; i++) {
            int boardSize = Integer.parseInt(br.readLine());
            strArr = br.readLine().split(" ");
            int startX = Integer.parseInt(strArr[0]);
            int startY = Integer.parseInt(strArr[1]);
            strArr = br.readLine().split(" ");
            int endX = Integer.parseInt(strArr[0]);
            int endY = Integer.parseInt(strArr[1]);

            visited = new boolean[boardSize][boardSize];
            bfs(visited, startX, startY, endX, endY);
        }

        System.out.println(sb);
    }

    private static void bfs(boolean[][] visited, int startX, int startY, int endX, int endY) {
        visited[startX][startY] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int x = val[0];
            int y = val[1];
            int count = val[2];

            if (x == endX && y == endY) {
                sb.append(count + "\n");
                break;
            }

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (nextX >= 0 && nextX < visited.length && nextY >= 0 && nextY < visited.length) {
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY, count + 1});
                    }
                }
            }
        }
    }
}
