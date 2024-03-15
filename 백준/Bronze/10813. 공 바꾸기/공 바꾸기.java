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
        int[] basket = new int[n+1];
        for (int i=1; i<=n; i++) {
            basket[i] = i;
        }

        for (int a = 0; a < m; a++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int tmp = basket[i];
            basket[i] = basket[j];
            basket[j] = tmp;
        }

        for (int i=1; i<=n; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}