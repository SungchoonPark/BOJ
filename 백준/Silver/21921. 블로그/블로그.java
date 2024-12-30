import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int[] cnt;
    static int minACnt;
    static int minCCnt;
    static int minGCnt;
    static int minTCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxDateCnt=0;
        int cnt = 0;
        for (int i = 0; i < x; i++) {
            cnt += arr[i];
        }

        int maxVisitor = cnt;
        if (maxVisitor != 0) maxDateCnt++;

        for (int i = 1; i < n - x + 1; i++) {
            cnt -= arr[i-1];
            cnt += arr[i + x - 1];

            if (cnt > maxVisitor) {
                maxDateCnt = 1;
                maxVisitor = cnt;
            } else if (cnt == maxVisitor) {
                maxDateCnt++;
            }
        }

        if (maxVisitor == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(maxVisitor);
        System.out.println(maxDateCnt);
    }
}