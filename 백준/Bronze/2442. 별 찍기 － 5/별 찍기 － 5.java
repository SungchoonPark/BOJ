import java.io.*;
import java.util.*;

public class Main {

   static StringTokenizer st;
   static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            int startCount = 2 * i - 1;

            sb.append(" ".repeat(n - i))
                .append("*".repeat(startCount));

            if (i!=n) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}