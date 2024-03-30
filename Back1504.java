package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Back1504_Node {
    int to;
    int weight;

    public Back1504_Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Back1504 {
    /*
        4 6
        1 2 3
        2 3 3
        3 4 1
        1 3 5
        2 4 5
        1 4 4
        2 3
       */
    static int[] dist;
    static ArrayList<ArrayList<Back1504_Node>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int node = Integer.parseInt(strArr[0]);
        int seq = Integer.parseInt(strArr[1]);
        list = new ArrayList<>();
        dist = new int[node + 1];
        for (int i = 0; i < node + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < seq; i++) {
            strArr = br.readLine().split(" ");
            list.get(Integer.parseInt(strArr[0])).add(new Back1504_Node(Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2])));
            list.get(Integer.parseInt(strArr[1])).add(new Back1504_Node(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[2])));
        }

        strArr = br.readLine().split(" ");
        int val1 = Integer.parseInt(strArr[0]);
        int val2 = Integer.parseInt(strArr[1]);

        int result = 0;
        result += back1504_dijkstra(1, val1) == -1 ? -1000000 : back1504_dijkstra(1, val1);
        result += back1504_dijkstra(val1, val2) == -1 ? -1000000 : back1504_dijkstra(val1, val2);
        result += back1504_dijkstra(val2, node) == -1 ? -1000000 : back1504_dijkstra(val2, node);

        int result2 = 0;
        result2 += back1504_dijkstra(1, val2) == -1 ? -1000000 : back1504_dijkstra(1, val2);
        result2 += back1504_dijkstra(val2, val1) == -1 ? -1000000 : back1504_dijkstra(val2, val1);
        result2 += back1504_dijkstra(val1, node) == -1 ? -1000000 : back1504_dijkstra(val1, node);

        if (result2 < 0 && result < 0) {
            System.out.println(-1);
        } else if (result < 0) {
            System.out.println(result2);
        } else if (result2 < 0){
            System.out.println(result);
        } else {
            System.out.println(Math.min(result, result2));
        }
    }

    private static int back1504_dijkstra(int start, int end) {
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Back1504_Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Back1504_Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Back1504_Node curBack1504Node = pq.remove();
            if (dist[curBack1504Node.to] < curBack1504Node.weight) {
                continue;
            }

            for (int i = 0; i < list.get(curBack1504Node.to).size(); i++) {
                Back1504_Node preBack1504Node = list.get(curBack1504Node.to).get(i);

                if (dist[preBack1504Node.to] > preBack1504Node.weight + curBack1504Node.weight) {
                    dist[preBack1504Node.to] = preBack1504Node.weight + curBack1504Node.weight;
                    pq.add(new Back1504_Node(preBack1504Node.to, dist[preBack1504Node.to]));
                }
            }
        }

        return dist[end] == Integer.MAX_VALUE ? - 1 : dist[end];
    }
}
