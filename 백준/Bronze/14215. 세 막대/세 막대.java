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
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());

        int tmp = 0;
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        set.add(a);
        set.add(b);
        set.add(c);
        tmp = a + b + c;
        int max = Math.max(a, Math.max(b, c));

        if (set.size() == 1) {
            sb.append(a * 3);
        } else {
            if (tmp - max <= max) {
                sb.append(((tmp - max) + (tmp - max - 1)));
            } else {
                sb.append((a+b+c));
            }
        }

        System.out.println(sb);
    }
}
