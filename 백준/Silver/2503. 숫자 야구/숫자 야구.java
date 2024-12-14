import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<BaseBall> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            // 스트라이크란 자리와 수 모두 맞은 경우
            // 볼이라면 숫자만 맞은 경우

            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            list.add(new BaseBall(num, strike, ball));
        }

        Set<Character> set;
        int result = 0;
        for (int i = 123; i < 1000; i++) {
            set = new HashSet<>();
            char[] charArray = String.valueOf(i).toCharArray();
            for (char c : charArray) {
                set.add(c);
            }
            if (set.size() != 3) continue;
            if (set.contains('0')) continue;

            boolean isValid = true;
            for (BaseBall baseBall : list) {
                if (!compareNum(i, baseBall)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) result++;
        }

        System.out.println(result);
    }

    private static boolean compareNum(int a, BaseBall pivot) {
        String pivotstring = String.valueOf(pivot.num);
        String[] pivotNums = pivotstring.split("");
        String[] value = String.valueOf(a).split("");

        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            if (value[i].equals(pivotNums[i])) strikeCount++;
            else if (pivotstring.contains(value[i])) ballCount++;
        }

        return strikeCount == pivot.strike && ballCount == pivot.ball;
    }

    static class BaseBall {
        int num;
        int strike;
        int ball;

        public BaseBall(int num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }
}