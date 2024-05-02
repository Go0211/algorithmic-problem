package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Back11047 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int seq = Integer.parseInt(strArr[0]);
        int money = Integer.parseInt(strArr[1]);
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((x1, x2) -> x2 - x1);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < seq; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while (money != 0 && !pq.isEmpty()) {
            int num = pq.remove();

            while (money >= num) {
                money -= num;
                count++;
            }
        }

        System.out.println(count);
    }
}
