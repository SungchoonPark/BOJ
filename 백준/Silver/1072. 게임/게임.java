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
        // 변수에 실수형을 저장하면 오차가 발생함. ex) double 0.58 * 100 은 58이 아닌 57이 된다.
        // 따라서 실수를 계산할때는 최대한 정수범위 안에서 처리를 해야한다. 
        // 따라서 Y * 100을 먼저 하는거임.
        return (int) (Y * 100 / X);
    }
}
