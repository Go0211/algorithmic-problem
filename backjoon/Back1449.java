package algorithm_problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Back1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int seq = Integer.parseInt(strArr[0]);
        int len = Integer.parseInt(strArr[1]);
        ArrayList<Integer> list = new ArrayList<>();

        strArr = br.readLine().split(" ");
        for (int i = 0; i < strArr.length; i++) {
            list.add(Integer.parseInt(strArr[i]));
        }

        list.sort((x1, x2) -> x1 - x2);

        for (int i = 0; i < list.size(); i++) {
            int max = (int)(list.get(i) + len - 0.5);

            while (true) {
                if (i + 1 < list.size() && max >= list.get(i + 1)) {
                    list.remove(i + 1);
                } else {
                    break;
                }
            }
        }

        System.out.println(list.size());
    }
}
