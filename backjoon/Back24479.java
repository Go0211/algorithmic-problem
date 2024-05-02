package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Back24479 {
    static int[] arr;
    static ArrayList<ArrayList<Integer>> list;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int node = Integer.parseInt(strArr[0]);
        int seq = Integer.parseInt(strArr[1]);
        int start = Integer.parseInt(strArr[2]);
        arr = new int[node + 1];

        list = new ArrayList<>();
        for (int i = 0; i < node + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < seq; i++) {
            strArr = br.readLine().split(" ");
            list.get(Integer.parseInt(strArr[0])).add(Integer.parseInt(strArr[1]));
            list.get(Integer.parseInt(strArr[1])).add(Integer.parseInt(strArr[0]));
        }

        for (int i = 1; i < node + 1; i++) {
            list.get(i).sort((x1 ,x2) -> x1 - x2);
        }

        count = 1;
        dfs(start);

        for (int i = 1; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void dfs(int start) {
        arr[start] = count;

        for (int i = 0; i < list.get(start).size(); i++) {
            int val = list.get(start).get(i);
            if (arr[val] == 0) {
                count++;
                dfs(val);
            }
        }
    }
}
