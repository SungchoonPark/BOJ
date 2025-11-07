import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int MAXH = 1_000_000;          // 문제 최대 높이
        int[] need = new int[MAXH + 1 + 1];  // need[h] = 높이 h에서 기다리는 화살 수
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());

            if (need[h] > 0) {
                // 기다리던 화살로 이 풍선을 맞춤 -> 그 화살은 h-1로 내려감
                need[h]--;
                need[h - 1]++;
            } else {
                // 새 화살이 필요 -> 하나 쏘고 h-1로 내려감
                ans++;
                need[h - 1]++;
            }
        }

        System.out.println(ans);
    }
}