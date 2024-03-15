package algorithm_problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Back10971 {
    static ArrayList<Integer> arrayList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int[][] arr = new int[seq][seq];
        arrayList = new ArrayList<>();

        for (int i = 0; i < seq; i++) {
            String[] sArr = br.readLine().split(" ");
            for (int j = 0; j < sArr.length; j++) {
                int val = Integer.parseInt(sArr[j]);

                arr[i][j] = val;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            dfs(arr, i);
        }

        Collections.sort(arrayList);
        System.out.println(arrayList.get(0));
    }

    private static void dfs(int[][] arr, int start) {
        Stack<Object[]> stack = new Stack<>();
        boolean[] v = new boolean[arr.length];

        stack.add(new Object[]{start, 0, 1, v});

        while (!stack.isEmpty()) {
            Object[] val = stack.pop();
            int idx = (int)val[0];
            int count = (int)val[1];
            int result = (int)val[2];
            boolean[] visited = (boolean[]) val[3];

            if (result == arr.length) {
                if (arr[idx][start] != 0) {
                    arrayList.add(count + arr[idx][start]);
                }
                continue;
            }

            if (result == 4) {
                arrayList.add(count);
            }

            for (int i = 0; i < arr.length; i++) {
                if (!visited[i] && arr[idx][i] != 0) {
                    visited[i] = true;
                    stack.push(new Object[]{i, count + arr[idx][i], result+1, visited.clone()});
                    visited[i] = false;
                }
            }
        }
    }
}
