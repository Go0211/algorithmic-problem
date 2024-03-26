package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node {
    int to;
    int w;

    public Node(int to, int w) {
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

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i < node + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edge; i++) {
            strArr = br.readLine().split(" ");
            list.get(Integer.parseInt(strArr[0]))
                    .add(new Node(Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2])));
        }

        dijkstra(list, node, start);
    }

    private static void dijkstra(ArrayList<ArrayList<Node>> list, int node, int start) {
        int[] dist = new int[node + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.w - y.w);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.remove();

            if (curNode.w > dist[curNode.to]) {
                continue;
            }

            for (int i = 0; i < list.get(curNode.to).size(); i++) {
                Node preNode = list.get(curNode.to).get(i);

                if (dist[preNode.to] > curNode.w + preNode.w) {
                    dist[preNode.to] = curNode.w + preNode.w;
                    pq.add(new Node(preNode.to, dist[preNode.to]));
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
