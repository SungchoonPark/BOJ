import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int[] arr;
    static StringBuilder sb;
    static int N, K, cv;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        cv = 0;
        cv |= 1 << 0;
        cv |= 1 << ('n' - 'a');
        cv |= 1 << ('t' - 'a');
        cv |= 1 << ('i' - 'a');
        cv |= 1 << ('c' - 'a');

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        if (K < 5) {
            System.out.println("0");
            return;
        }

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            int tmpValue = 0;
            for (char c : tmp.toCharArray()) {
                tmpValue |= 1 << c - 'a';
            }
            arr[i] = tmpValue;
        }

        dfs(cv, 5, 0);

        System.out.println(max);
    }

    private static void dfs(int newBit, int depth, int start) {
        if (depth == K) {
            int cnt = 0;
            // 비교
            for (int inputWord : arr) {
//                if ((inputWord | newBit) == newBit) cnt++;
                if ((inputWord & newBit) == inputWord) cnt++;
            }
            if (cnt > max) max = cnt;
            return;
        }

        for (int i = start; i < 26; i++) {
            if ((newBit & (1 << i)) != 0) continue;
            newBit |= 1 << i;
            dfs(newBit, depth+1, i + 1);
            newBit &= ~(1 << i);
        }
    }
}
