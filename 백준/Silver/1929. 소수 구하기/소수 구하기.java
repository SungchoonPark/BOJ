import java.io.*;
import java.util.*;

public class Main {

   static StringTokenizer st;
   static StringBuilder sb;

   static boolean[] isNotDecimal = new boolean[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        erathos();

        for (int i = m; i <= n; i++) {
            if (!isNotDecimal[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void erathos() {
        Arrays.fill(isNotDecimal, false);
        isNotDecimal[1] = true;
        for (int i = 2; i <= isNotDecimal.length; i++) {
            for (int j = i * 2; j <= isNotDecimal.length; j += i) {
                if (j < isNotDecimal.length && !isNotDecimal[j]) {
                    isNotDecimal[j] = true;
                }
            }
        }


    }
}