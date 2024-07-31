import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    private static int[] number;
    private static int[] ops = new int[4];
    private static int N;
    private static int MAX = Integer.MIN_VALUE;
    private static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        number = new int[N];

        st = new StringTokenizer(br.readLine());
        int a = 0;
        while (st.hasMoreTokens()) {
            number[a++] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }


    public static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {

                ops[i]--;
                switch (i) {
                    case 0: dfs(num + number[idx], idx + 1);   break;
                    case 1:	dfs(num - number[idx], idx + 1);   break;
                    case 2:	dfs(num * number[idx], idx + 1);   break;
                    case 3: dfs(num / number[idx], idx + 1);   break;
                }
                ops[i]++;
            }
        }
    }
}
