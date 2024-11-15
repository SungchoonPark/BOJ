import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int sum = arr[i];
            if (sum == m) {
                cnt++;
            } else if (sum < m) {
                for (int j = i + 1; j < n; j++) {
                    sum += arr[j];

                    if (sum == m) {
                        cnt++;
                        break;
                    }

                    if (sum > m) break;
                }
            }
        }

        System.out.println(cnt);
    }
}