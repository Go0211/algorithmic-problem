package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Back14487 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < strArr.length; i++) {
            pq.add(Integer.parseInt(strArr[i]));
        }

        int count = 0;
        while (pq.size() != 1) {
            count += pq.remove();
        }

        System.out.println(count);
    }
}
