import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int result = 0;
        if (n == 1) {
            result = 1;
        } else if (n == 2) {
            result = Math.min(4, (m + 1) / 2);
        } else if (n >= 3) {
            if (m < 7) {
                result = Math.min(4, m);
            } else {
                result = m - 2;
            }
        }

        System.out.println(result);
    }
}