import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder max;
    static StringBuilder min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 1. 만들 수 있는 모든 경우 다 만들어보기
        // 2. max값과 min값 갱신하면서 해보기

        // 10^N 은 -> M 을 N+1 개로
        // 5 x 10^N 은 -> (N개의 M) + K 한 것
        max = new StringBuilder();
        min = new StringBuilder();

        int consecutiveM = 0;
        for (int i = 0; i < input.length(); i++) {
            char curC = input.charAt(i);

            if (curC == 'M') {
                consecutiveM++;
            } else if (curC == 'K'){
                // 1. 최대값 나오게하기
                if (consecutiveM > 0) {
                    max.append('5');
                    for (int j = 0; j < consecutiveM; j++) {
                        max.append('0');
                    }
                } else {
                    max.append('5');
                }

                // 2. 최솟값 나오게하기
                if (consecutiveM > 0) {
                    min.append('1');
                    for (int j = 1; j < consecutiveM; j++) {
                        min.append('0');
                    }
                    min.append('5');
                } else {
                    min.append('5');
                }
                consecutiveM = 0;
            }
        }

        if (consecutiveM > 0) {
            for (int i = 0; i < consecutiveM; i++) {
                max.append('1');
            }

            min.append('1');
            for (int i = 1; i < consecutiveM; i++) {
                min.append('0');
            }
        }

        System.out.println(max);
        System.out.println(min);
    }
}