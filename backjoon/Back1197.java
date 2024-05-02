package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back1197 {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int nodeCount = Integer.parseInt(strArr[0]);
        int seq = Integer.parseInt(strArr[1]);
        parent = new int[nodeCount + 1];

        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        int[][] arr = new int[seq][3];

        for (int i = 0; i < seq; i++) {
            strArr = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(strArr[0]);
            arr[i][1]  = Integer.parseInt(strArr[1]);
            arr[i][2]  = Integer.parseInt(strArr[2]);
        }

        Arrays.sort(arr, (x, y) -> x[2] - y[2]);

        int weight = 0;
        for (int[] a : arr) {
            if (find(parent[a[0]]) != find(parent[a[1]])) {
                union(a[0], a[1]);
                weight += a[2];
            }
        }

        System.out.println(weight);
    }

    private static void union(int a, int b) {
        int aP = find(parent[a]);
        int bP = find(parent[b]);

        if (aP != bP) {
            parent[aP] = bP;
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }
}
