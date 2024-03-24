package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Back18352 {
    static ArrayList<ArrayList<Integer>> arr;
    static ArrayList<Integer> list;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int seq = Integer.parseInt(strArr[1]);
        int len = Integer.parseInt(strArr[2]);
        int start = Integer.parseInt(strArr[3]);

        arr = new ArrayList<>();
        list = new ArrayList<>();
        sb = new StringBuffer();
        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < seq; i++) {
            strArr = br.readLine().split(" ");
            arr.get(Integer.parseInt(strArr[0])).add(Integer.parseInt(strArr[1]));
        }

        bfs(new boolean[n + 1], start, len);
        list.sort((x1, x2) -> x1 - x2);

        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int a : list) {
                System.out.println(a);
            }
        }
    }

    private static void bfs(boolean[] visited, int start, int len) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int idx = val[0];
            int idxSize = val[1];

            if (idxSize == len) {
                list.add(idx);
            }

            for (int i = 0; i < arr.get(idx).size(); i++) {
                int next = arr.get(idx).get(i);

                if (!visited[next] && len > idxSize) {
                    visited[next] = true;
                    queue.add(new int[]{next, idxSize + 1});
                }
            }
        }
    }
}
