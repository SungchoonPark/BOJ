import java.io.*;
import java.util.*;

public class Main {

   static StringTokenizer st;
   static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            sb.append("*".repeat(n - i))
                .append("".repeat(i));
            if (i != n - 1) sb.append('\n');
        }
        System.out.print(sb);
    }
}