import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N <= x <= M 인 소수 x를 찾고 x의 합을 구하고 최솟값을 구하라.
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[N + 1];

        arr[0] = true;
        arr[1] = true;

        int sum = 0;

        for (int i = 2; i <= Math.sqrt(N + 1); i++) {
            for (int j = i * i; j < N + 1; j += i) {
                arr[j] = true;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = M; i <= N; i++) {
            if (!arr[i]) {
                sum += i;
                if (i < min) {
                    min = i;
                }
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }

    }
}

