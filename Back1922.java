package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back1922 {
    static int result = 0;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int com = Integer.parseInt(br.readLine());
        int seq = Integer.parseInt(br.readLine());

        parent = new int[com + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        int[][] arr = new int[seq][3];
        for (int i = 0; i < seq; i++) {
            String[] strArr = br.readLine().split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            int c = Integer.parseInt(strArr[2]);
            arr[i] = new int[]{a, b, c};
        }

        Arrays.sort(arr, (x, y) -> x[2] - y[2]);

        back1922(arr);
        System.out.println(result);
    }

    private static void back1922(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (find(arr[i][0]) != find(arr[i][1])) {
                union(arr[i][0], arr[i][1]);
                result += arr[i][2];
            }
        }
    }

    private static void union(int a, int b) {
        int aP = find(a);
        int bP = find(b);

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
