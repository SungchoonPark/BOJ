import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double n = Double.parseDouble(st.nextToken());

        a %= b;

        int result = 0;
        for (int i = 1; i <= n; i++) {
            a *= 10;
            if (i == n) {
                result = (int) ((int) a / b);
                break;
            }
            a %= b;
        }

        System.out.println(result);
    }
}