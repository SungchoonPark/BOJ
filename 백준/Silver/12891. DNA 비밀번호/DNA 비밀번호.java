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
        int length = Integer.parseInt(st.nextToken());

        String strs = br.readLine();
        char[] arr = strs.toCharArray();

        st = new StringTokenizer(br.readLine());
        minACnt = Integer.parseInt(st.nextToken());
        minCCnt = Integer.parseInt(st.nextToken());
        minGCnt = Integer.parseInt(st.nextToken());
        minTCnt = Integer.parseInt(st.nextToken());

        cnt = new int[4];
        for (int i = 0; i < length; i++) {
            if (arr[i] == 'A') {
                cnt[0]++;
            } else if (arr[i] == 'C') {
                cnt[1]++;
            } else if (arr[i] == 'G') {
                cnt[2]++;
            } else {
                cnt[3]++;
            }
        }

        int result = 0;
        if (isValid()) result++;

        for (int i = 1; i < arr.length - length + 1; i++) {
            char prevChar = arr[i - 1];
            char nextChar = arr[i + length - 1];

            if (prevChar == 'A') {
                cnt[0]--;
            } else if (prevChar == 'C') {
                cnt[1]--;
            } else if (prevChar == 'G') {
                cnt[2]--;
            } else {
                cnt[3]--;
            }

            if (nextChar == 'A') {
                cnt[0]++;
            } else if (nextChar == 'C') {
                cnt[1]++;
            } else if (nextChar == 'G') {
                cnt[2]++;
            } else {
                cnt[3]++;
            }

            if (isValid()) result++;
        }

        System.out.println(result);
    }

    private static boolean isValid() {
        return cnt[0] >= minACnt && cnt[1] >= minCCnt && cnt[2] >= minGCnt && cnt[3] >= minTCnt;
    }
}