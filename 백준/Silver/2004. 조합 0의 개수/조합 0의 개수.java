import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if (n == m) {
            System.out.println(0);
            return;
        }
        int five = getFive(n) - getFive(n-m) - getFive(m);
        int two = getTwo(n) - getTwo(n-m) - getTwo(m);
        System.out.println(Math.min(five, two));
    }

    private static int getFive(int n) {
        int cnt = 0;
        while (n >= 5) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }

    private static int getTwo(int n) {
        int cnt = 0;
        while (n >= 2) {
            cnt += n / 2;
            n /= 2;
        }
        return cnt;
    }
}
