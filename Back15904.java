package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Back15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayList<Character> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) - 65 >= 0 && str.charAt(i) - 65 < 26) {
                list.add(str.charAt(i));
            }
        }

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            if (c == 'U' || c == 'C' || c == 'P') {
                if (count == 0) {
                    if (c == 'U') {
                        count++;
                    }
                } else if (count == 1) {
                    if (c == 'C') {
                        count++;
                    }
                } else if (count == 2) {
                    if (c == 'P') {
                        count++;
                    }
                } else if (count == 3) {
                    if (c == 'C') {
                        count++;
                        break;
                    }
                }
            }
        }

        if (count == 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}
