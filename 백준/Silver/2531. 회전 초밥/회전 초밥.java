import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int sushiUniqueCnt = Integer.parseInt(st.nextToken());
        int consecutiveCnt = Integer.parseInt(st.nextToken());
        int couponNum = Integer.parseInt(st.nextToken());

        int[]arr = new int[n];
        // 먹을 수 있는 최대 초밥 종류를 구하여라
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] numCnt = new int[sushiUniqueCnt + 1];

        // 초기 설정
        int start = 0;
        int end = start + consecutiveCnt - 1;
        for (int i = start; i <= end; i++) {
            if (arr[i] == couponNum) continue;
            numCnt[arr[i]]++;
        }

        int tmpCnt = 0;
        for (int i : numCnt) {
            if (i!=0) tmpCnt++;
        }
        int maxCnt = tmpCnt;
        while(start != n - 1) {
            int removeValue = arr[start++];
            numCnt[removeValue]--;
            if (numCnt[removeValue] == 0) tmpCnt--;
            end = (end + 1) % n;

            if (arr[end] == couponNum) continue;
            int addValue = arr[end];
            numCnt[addValue]++;
            if (numCnt[addValue]==1) tmpCnt++;
            if (tmpCnt > maxCnt) maxCnt = tmpCnt;
        }

        System.out.println(maxCnt + 1);
    }
}