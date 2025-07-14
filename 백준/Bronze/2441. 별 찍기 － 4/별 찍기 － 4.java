import java.io.*;
import java.util.*;

public class Main {

   static StringTokenizer st;
   static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        char star = '*';
        char blank = ' ';
        for (int i = 0; i < n; i++) {
            int starCount = n - i;
            int blankCount = i;

            for (int j = 0; j < blankCount; j++) {
                sb.append(blank);
            }

            for (int j = 0; j < starCount; j++) {
                sb.append(star);
            }
            if (i != n-1) {
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}