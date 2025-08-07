import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int sn = 1;
        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                break;
            }

            String[] names = new String[input + 1];
            for (int i = 1; i < input + 1; i++) {
                names[i] = br.readLine();
            }

            int[] count = new int[input + 1];
            for (int i = 0; i < 2 * input - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                String tmp = st.nextToken();

                count[n]++;
            }

            for (int i = 1; i < input + 1; i++) {
                if (count[i] != 2) {
                    sb.append(sn++).append(" ").append(names[i]).append("\n");
                }
            }
        }
        System.out.print(sb);

    }

}