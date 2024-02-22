import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static double H;
    private static int Y;
    private static double[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        money = new double[Y+1];
        money[0] = H;

        for(int i=1; i<=Y; i++) {
            money[i] = (long) Math.floor(money[i-1] * 1.05);
            if (i >= 5) {
                money[i] = Math.max(money[i], (long) Math.floor(money[i-5] * 1.35));
            }
            if (i >= 3) {
                money[i] = Math.max(money[i], (long) Math.floor(money[i-3] * 1.2));
            }
        }


        System.out.println((long)money[Y]);
    }
}


