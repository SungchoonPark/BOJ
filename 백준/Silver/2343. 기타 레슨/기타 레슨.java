import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        /***
         * 범위는 1부터 모든 강의의 길이를 합친 수까지
         * 블루레이 사이즈가 주어진경우 -> 이 블루레이 사이즈로 M개가 채워져야함
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] lectures = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch(M, lectures));
    }

    private static long binarySearch(int M, int[] lectures) {
        long start = 1;
        long end = 1_000_000_000;
        while (end > start) {
            long brSize = (start + end) / 2;

            if (cntBr(brSize, M, lectures) > M) {
                start = brSize + 1;
            } else {
                end = brSize;
            }
        }

        return start;
    }

    private static long cntBr(long brSize, int M, int[] lectures) {
        int cnt = 1;
        int tmp = 0;
        for (int lecture : lectures) {
            if (lecture > brSize) return M + 1;
            
            if (tmp + lecture > brSize) {
                cnt++;
                tmp = lecture;
            } else {
                tmp += lecture;
            }
        }

        return cnt;
    }
}


