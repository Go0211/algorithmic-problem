package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Edge11657 {
    int from;
    int to;
    int weight;

    public Edge11657(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

public class Back11657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int seq = Integer.parseInt(strArr[1]);
        Edge11657[] edges = new Edge11657[seq];

        for (int i = 0; i < seq; i++) {
            strArr = br.readLine().split(" ");
            edges[i] = new Edge11657(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2]));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        boolean isChange = false;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < edges.length; j++) {
                Edge11657 edge = edges[j];

                if (dist[edge.from] == Long.MAX_VALUE) {
                    continue;
                }

                if (dist[edge.to] > dist[edge.from] + edge.weight) {
                    dist[edge.to] = dist[edge.from] + edge.weight;

                    if (i == n) {
                        isChange = true;
                    }
                }
            }
        }

        long[] resultArr = new long[dist.length - 2];
        for (int i = 2; i < dist.length; i++) {
            resultArr[i - 2] = dist[i];
        }

        if (isChange) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < resultArr.length; i++) {
                if (resultArr[i] == Long.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(resultArr[i]);
                }
            }
        }
    }
}
