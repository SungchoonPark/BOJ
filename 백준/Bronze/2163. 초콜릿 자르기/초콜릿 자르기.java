import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        divide(n, m);
        System.out.print(result);
    }

    private static void divide(int n, int m) {
        if (n == 1 || m == 1) {
            if (n == 1) {
                result += (m - 1);
            } else {
                result += (n - 1);
            }
        } else {
            if (n >= m) {
                result++;
                divide(n, 1);
                divide(n, m-1);

            } else {
                result++;
                divide(1, m);
                divide(n-1, m);
            }
        }
    }
}