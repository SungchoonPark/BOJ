import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static int[] lans;
    private static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lans = new int[K];

        for (int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(binarySearch());
    }

    private static long binarySearch() {
        long start = 1;
        long end = Integer.MAX_VALUE;

        while (end >= start) {
            long lanLength = (start + end) / 2;
            long cnt = cntFromLanLength(lanLength);
            if (cnt >= N) {
                start = lanLength + 1;
            } else {
                end = lanLength - 1;
            }
        }

        return start - 1;
    }

    private static long cntFromLanLength(long lanLength) {
        int cnt = 0;
        for (int lan : lans) {
            cnt += (lan / lanLength);
        }
        return cnt;
    }
}


