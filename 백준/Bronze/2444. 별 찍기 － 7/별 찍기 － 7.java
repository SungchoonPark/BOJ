import java.io.*;
import java.util.*;

public class Main {

   static StringTokenizer st;
   static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int tryCount = 2 * n - 1;
        for (int i = 1; i <= tryCount; i++) {
            int startCount = 0;
            if (i > n) {
                startCount = tryCount - (2 * (i - n));
            } else {
                startCount = 2 * i - 1;
            }
            int blankCount = Math.abs(n - i);

            sb.append(" ".repeat(blankCount))
                .append("*".repeat(startCount));

            if (i != tryCount) sb.append("\n");
        }
        System.out.print(sb);
    }
}