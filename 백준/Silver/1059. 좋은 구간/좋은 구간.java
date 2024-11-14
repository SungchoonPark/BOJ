import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int[] s=  new int[l];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < l; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());
        Arrays.sort(s);

        int start = 1;
        int end = 0;
        for (int i : s) {
            if (i < n) start = i + 1;
            if (i == n) {
                System.out.println(0);
                return;
            }
            if (i > n) {
                end = i;
                break;
            }
        }

        int cnt = 0;
        for (int i = start; i <= n; i++) {
            for (int j = n; j < end; j++) {
                if (i == j) continue;

                cnt++;
            }
        }

        System.out.println(cnt);

    }
}