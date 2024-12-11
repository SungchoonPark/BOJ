import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] dp = new int[300_000];
        Arrays.fill(dp, -1);

        List<Integer> list = new ArrayList<>();
        while(true) {
            if (dp[a] != -1) {
                int cnt = 0;
                for (Integer i : list) {
                    if (i == a) break;
                    cnt++;
                }
                System.out.println(cnt);
                return;
            }

            int transValue = trans(a, p);
            list.add(a);
            dp[a] = transValue;
            a = transValue;
        }
    }

    private static int trans(int a, int p) {
        int result= 0;
        for (String s : String.valueOf(a).split("")) {
            int i = Integer.parseInt(s);

            result += (int) Math.pow(i, p);
        }

        return result;
    }
}