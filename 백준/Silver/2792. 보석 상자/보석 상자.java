import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static int[] gems;
    private static int N, M;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        gems = new int[M];

        for (int i = 0; i < M; i++) {
            gems[i] = Integer.parseInt(br.readLine());
            if (gems[i] > max) max = gems[i];
        }
        System.out.println(binarySearch());
    }

    private static long binarySearch() {
        long start = 1;
        long end = Integer.MAX_VALUE;

        while (end > start) {
            long jealous = (start + end) / 2;
            long cnt = cntFromJealous(jealous);
            if (cnt <= N) {
                end = jealous;
            } else {
                start = jealous + 1;
            }
        }

        return start;
    }


    private static long cntFromJealous(long jealous) {
        long cnt = 0;
        for (int gem : gems) {
            if (gem % jealous != 0) {
                cnt = cnt + (gem / jealous) + 1;
            } else {
                cnt += gem / jealous;
            }
        }
        return cnt;
    }
}


