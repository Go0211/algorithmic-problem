package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Back1647_Edge {
    int from;
    int to;
    int weight;

    public Back1647_Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

public class Back1647 {
    /*
    * 두 마을로 분리
    * 마을안에 집은 서로 연결
    * 마을안에는 집이 하나 이상있어야한다
    * 마을안 집이 연결되고 나머지 길을 삭제했을 때 최소 유지비
    *
    * 그럼 mst(최소신장트리) -> 제일 큰 값을 삭제
    * */
    static int[] parent;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");

        int n = Integer.parseInt(strArr[0]);
        int seq = Integer.parseInt(strArr[1]);
        parent = new int[n + 1];
        PriorityQueue<Back1647_Edge> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);

        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < seq; i++) {
            strArr = br.readLine().split(" ");
            pq.add(new Back1647_Edge(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2])));
        }

        int removeNum = 0;
        while (!pq.isEmpty()) {
            Back1647_Edge edge = pq.remove();

            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                result += edge.weight;
                removeNum = edge.weight;
            }
        }

        result -= removeNum;
        System.out.println(result);
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
