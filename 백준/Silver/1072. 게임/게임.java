import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = getWinRateFromGameNUm(X, Y);
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        System.out.println(binarySearch(X, Y, Z));
    }

    private static long binarySearch(int X, int Y, int Z) {
        long start = 1;
        long end = 1_000_000_000_000L;
        boolean flag = false;
        while(end > start) {
            long gameNum = (start + end) / 2;

            if(getWinRateFromGameNUm(X + gameNum, Y + gameNum) > Z) {
                flag = true;
                end = gameNum;
            } else {
                start = gameNum + 1;
            }
        }

        if (!flag) return -1;
        return start;
    }

    private static int getWinRateFromGameNUm(long X, long Y) {
        return (int) (Y * 100 / X);
    }
}
