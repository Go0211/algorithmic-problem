package algorithm_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back11034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        StringBuffer sb = new StringBuffer();
        while (true) {
            str = br.readLine();

            if (str == null || str.equals("")) {
                break;
            }

            String[] strArr = str.split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            int c = Integer.parseInt(strArr[2]);

            int aa = b - a;
            int bb = c - b;

            if (aa > bb) {
                sb.append(aa - 1+"\n");
            } else {
                sb.append(bb - 1+"\n");
            }
        }

        System.out.println(sb);
    }
}
