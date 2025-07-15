import java.io.*;
import java.util.*;

public class Main {

   static StringTokenizer st;
   static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int count = n;
        for (int i = 1; i <= count; i++) {
            int startCount = 2 * n - 1;

            sb.append(" ".repeat(i-1))
                .append("*".repeat(startCount));

            n--;
            if (i != count) sb.append("\n");
        }
        System.out.print(sb);
    }
}