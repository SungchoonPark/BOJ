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
        while (true) {
            Set<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int tmp = 0;

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) break;
            set.add(a);
            set.add(b);
            set.add(c);
            tmp = a + b + c;
            int max = Math.max(a, Math.max(b, c));

            if (tmp - max <= max) {
                sb.append("Invalid").append("\n");
            } else if (set.size() == 1) {
                sb.append("Equilateral").append("\n");
            } else if (set.size() == 2) {
                sb.append("Isosceles").append("\n");
            } else if (set.size() == 3) {
                sb.append("Scalene").append("\n");
            }
        }

        System.out.println(sb);
    }
}
