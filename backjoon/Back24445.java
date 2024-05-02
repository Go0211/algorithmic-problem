package algorithm_problem.backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Back24445 {
    static ArrayList<ArrayList<Integer>> list;
    static int count = 1;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int node = Integer.parseInt(strArr[0]);
        int seq = Integer.parseInt(strArr[1]);
        int start = Integer.parseInt(strArr[2]);

        list = new ArrayList<>();
        arr = new int[node + 1];
        for (int i = 0; i < node + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < seq; i++) {
            strArr = br.readLine().split(" ");
            list.get(Integer.parseInt(strArr[0])).add(Integer.parseInt(strArr[1]));
            list.get(Integer.parseInt(strArr[1])).add(Integer.parseInt(strArr[0]));
        }

        for (int i = 0; i < node + 1; i++) {
            list.get(i).sort((x1 , x2) -> x2 - x1);
        }

        bfs(start);
        for (int i = 1; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[list.size()];
        visited[start] = true;

        while (!queue.isEmpty()) {
            int val = queue.remove();
            arr[val] = count++;

            for (int i = 0; i < list.get(val).size(); i++) {
                int a = list.get(val).get(i);

                if (!visited[a]) {
                    visited[a] = true;
                    queue.add(a);
                }
            }
        }
    }
}
