package algorithm_problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Back2644 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int start = Integer.parseInt(strArr[0]);
        int end = Integer.parseInt(strArr[1]);
        int seq = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i < seq; i++) {
            strArr = br.readLine().split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        int result = dfs(arr, start, end, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

//    private static int dfs(int[][] arr, int start, int end, int count) {
//        if (start == end) {
//            return count;
//        }
//
//        int min = Integer.MAX_VALUE;
//        for (int i = 1; i < arr[start].length; i++) {
//            if (arr[start][i] == 1) {
//                arr[start][i] = 0;
//                int dist = dfs(arr, i, end, count + 1);
//                if (dist != Integer.MAX_VALUE) {
//                    min = Math.min(dist, min);
//                }
//                arr[start][i] = 1;
//            }
//        }
//
//        return min;
//    }
    private static int dfs(int[][] arr, int start, int end, int count) {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{start, 0});

        while (!stack.isEmpty()) {
            int[] stackArr = stack.pop();
            int a = stackArr[0];
            int c = stackArr[1];

            if (a == end) {
                return c;
            }

            for (int i = 0; i < arr[a].length; i++) {
                if (arr[a][i] == 1) {
                    arr[a][i] = 0;
                    stack.add(new int[]{i, c + 1});
                }
            }
        }

        return -1;
    }
}
