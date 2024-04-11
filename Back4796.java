package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Back4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            String[] strArr = br.readLine().split(" ");
            int val = Integer.parseInt(strArr[0]);
            int limit = Integer.parseInt(strArr[1]);
            int max = Integer.parseInt(strArr[2]);
            int count = 0;

            if (val == 0 && limit == 0 && max == 0) {
                break;
            }

            while (true) {
                if (max - limit > 0) {
                    count += val;
                    max -= limit;
                } else {
                    if (max - val >= 0) {
                        count += val;
                    } else {
                        count += max;
                    }
                    break;
                }
            }

            list.add(count);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Case " + (i + 1) + ": " + list.get(i));
        }
    }
}
