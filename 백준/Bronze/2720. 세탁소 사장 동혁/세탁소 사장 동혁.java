import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int money = Integer.parseInt(br.readLine());
            int q = 0;
            int d = 0;
            int ni = 0;
            int p = 0;
            if (money >= 25) {
                q = money / 25;
                money %= 25;
            }
            if (money >= 10) {
                d = money / 10;
                money %= 10;
            }
            if (money >= 5) {
                ni = money / 5;
                money %= 5;
            }
            if (money != 0) {
                p = money;
            }
            sb.append(q + " ").append(d + " ").append(ni + " ").append(p + " " + "\n");
        }

        System.out.println(sb);

    }
}
