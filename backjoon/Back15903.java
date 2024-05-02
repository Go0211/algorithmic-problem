package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Back15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int len = Integer.parseInt(strArr[0]);
        int mix = Integer.parseInt(strArr[1]);
        strArr = br.readLine().split(" ");
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < strArr.length; i++) {
            pq.add(Long.parseLong(strArr[i]));
        }

        for (int i = 0; i < mix; i++) {
            long a = pq.remove();
            long b = pq.remove();
            pq.add(a+b);
            pq.add(a+b);
        }

        long total = 0;
        while (!pq.isEmpty()) {
            total += pq.remove();
        }

        System.out.println(total);
    }
}
