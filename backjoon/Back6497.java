package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Node_Back6497 {
    int from;
    int to;
    long w;

    public Node_Back6497(int from, int to, long w) {
        this.from = from;
        this.to = to;
        this.w = w;
    }
}

public class Back6497 {
    /*불이 켜진 길만으로 서로를 왕래

    각 테스트 케이스의 첫째 줄에는 집의 수 m과 길의 수 n이 주어진다. (1 ≤ m ≤ 200000, m-1 ≤ n ≤ 200000)

    x번 집과 y번 집 사이에 양방향 도로,  거리가 z (0 ≤ x, y < m, x ≠ y)

    도시는 항상 연결 그래프의 형태이고(즉, 어떤 두 집을 골라도 서로 왕래할 수 있는 경로가 있다), 도시상의 모든 길의 거리 합은 2^31미터보다 작다.

    입력의 끝에서는 첫 줄에 0이 2개 주어진다.

    mst로 구하면 될 듯?
    *
    * */
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] strArr = br.readLine().split(" ");
            int n = Integer.parseInt(strArr[0]);
            int seq = Integer.parseInt(strArr[1]);

            if (n == 0 && seq == 0) {
                break;
            }

            parent = new int[200001];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            int answer = 0;
            ArrayList<Node_Back6497> list = new ArrayList<>();
            for (int i = 0; i < seq; i++) {
                strArr = br.readLine().split(" ");

                list.add(new Node_Back6497(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2])));
                list.add(new Node_Back6497(Integer.parseInt(strArr[1]), Integer.parseInt(strArr[0]), Integer.parseInt(strArr[2])));
                answer += Integer.parseInt(strArr[2]);
            }

            list.sort((x, y) -> (int) (x.w - y.w));

            int result = 0;
            for (int i = 0; i < list.size(); i++) {
                if (find(list.get(i).from) != find(list.get(i).to)) {
                    union(list.get(i).from, list.get(i).to);
                    result += list.get(i).w;
                }
            }

            System.out.println(answer - result);
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
