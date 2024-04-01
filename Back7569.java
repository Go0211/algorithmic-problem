package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back7569 {
    static final int[][] dirs = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        /*
        * 토마토가 익는데 걸리는 최소시간 (다 익는 게 불가 -> -1 / 시작부터 다 익음 -> 0)
        * 1 -> 익음 / 0 -> 안익음 / -1 -> 빈칸
        * 위, 아래, 앞, 뒤, 양옆 -> 익은 게 있으면 안익은걸 익을걸로 바꿈
        * 2 ≤ y ≤ 100, 2 ≤ x ≤ 100, 1 ≤ 높이 ≤ 100
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int y = Integer.parseInt(strArr[0]);
        int x = Integer.parseInt(strArr[1]);
        int h = Integer.parseInt(strArr[2]);

        int[][][] arr = new int[h][x][y];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < x; j++) {
                strArr = br.readLine().split(" ");
                for (int k = 0; k < strArr.length; k++) {
                    arr[i][j][k] = Integer.parseInt(strArr[k]);
                }
            }
        }

        boolean start = false;
        boolean notHaveOne = true;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < y; k++) {
                    if (arr[i][j][k] == 1) {
                        start = true;
                        notHaveOne = false;
                        break;
                    }
                }
                if (start) {
                    break;
                }
            }
            if (start) {
                break;
            }
        }

        if (start) {
            System.out.println(bfs(arr));
        } else if (notHaveOne) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }
    }

    private static int bfs(int[][][] arr) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                for (int k = 0; k < arr[0][0].length; k++) {
                    if (arr[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k, 0});
                    }
                }
            }
        }
        boolean[][][] visited = new boolean[arr.length][arr[0].length][arr[0][0].length];

        int answer = 0;
        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int h = val[0];
            int x = val[1];
            int y = val[2];
            answer = val[3];
            visited[h][x][y] = true;

            for (int[] a : dirs) {
                int hNext = a[0] + h;
                int xNext = a[1] + x;
                int yNext = a[2] + y;

                if (hNext >= 0 && hNext < arr.length) {
                    if (xNext >= 0 && xNext < arr[0].length && yNext >= 0 && yNext < arr[0][0].length) {
                        if (arr[hNext][xNext][yNext] == 0 && !visited[hNext][xNext][yNext]) {
                            arr[hNext][xNext][yNext] = 1;
                            visited[hNext][xNext][yNext] = true;
                            queue.add(new int[]{hNext, xNext, yNext, val[3] + 1});
                        }
                    }
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                for (int k = 0; k < arr[0][0].length; k++) {
                    if (arr[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }

        return answer;
    }
}
