package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Back1753_Node {
    int to;
    int w;

    public Back1753_Node(int to, int w) {
        this.to = to;
        this.w = w;
    }
}

public class Back1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int node = Integer.parseInt(strArr[0]);
        int edge = Integer.parseInt(strArr[1]);
        int start = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Back1753_Node>> list = new ArrayList<>();
        for (int i = 0; i < node + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edge; i++) {
            strArr = br.readLine().split(" ");
            list.get(Integer.parseInt(strArr[0]))
                    .add(new Back1753_Node(Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2])));
        }

        dijkstra(list, node, start);
    }

    private static void dijkstra(ArrayList<ArrayList<Back1753_Node>> list, int node, int start) {
        int[] dist = new int[node + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Back1753_Node> pq = new PriorityQueue<>((x, y) -> x.w - y.w);
        pq.add(new Back1753_Node(start, 0));

        while (!pq.isEmpty()) {
            Back1753_Node curBack1753_Node = pq.remove();

            if (curBack1753_Node.w > dist[curBack1753_Node.to]) {
                continue;
            }

            for (int i = 0; i < list.get(curBack1753_Node.to).size(); i++) {
                Back1753_Node preBack1753_Node = list.get(curBack1753_Node.to).get(i);

                if (dist[preBack1753_Node.to] > curBack1753_Node.w + preBack1753_Node.w) {
                    dist[preBack1753_Node.to] = curBack1753_Node.w + preBack1753_Node.w;
                    pq.add(new Back1753_Node(preBack1753_Node.to, dist[preBack1753_Node.to]));
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF ");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}
