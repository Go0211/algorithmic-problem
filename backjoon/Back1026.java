package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Back1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        String[] strArr1 = br.readLine().split(" ");
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < seq; i++) {
            list1.add(Integer.parseInt(strArr[i]));
            list2.add(Integer.parseInt(strArr1[i]));
        }

        list1.sort((x1, x2) -> x1 - x2);
        list2.sort((x1, x2) -> x2 - x1);
        for (int i = 0; i < seq; i++) {
            result += list1.get(i) * list2.get(i);
        }

        System.out.println(result);
    }
}
