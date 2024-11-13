import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = a[i];
        }

        Arrays.sort(b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] == b[j]) {
                    sb.append(j).append(" ");
                    b[j] = -1;
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}