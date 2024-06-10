import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String tmp = "";
            if (n == 0 && m == 0) break;

            if(m % n == 0) {
                tmp = "factor";
            } else if (n % m == 0) {
                tmp = "multiple";
            } else {
                tmp = "neither";
            }
            sb.append(tmp).append("\n");
        }

        System.out.println(sb);

    }
}
