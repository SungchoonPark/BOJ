import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // DP 배열 정의
        int[][] dp = new int[n + 1][10];

        // 초기값 설정 (길이가 1인 경우, 각 자리수는 1개씩 가능)
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        // DP 점화식 계산
        for (int i = 2; i <= n; i++) { // 길이
            for (int j = 0; j < 10; j++) { // 마지막 자리 숫자
                if (j > 0) { // j - 1이 유효한 경우만 누적
                    dp[i][j] = dp[i][j - 1];
                }
                dp[i][j] += dp[i - 1][j];
                dp[i][j] %= 10007; // 모듈러 연산
            }
        }

        // 결과 계산
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[n][i];
            result %= 10007; // 최종 모듈러 연산
        }

        System.out.println(result);
    }
}