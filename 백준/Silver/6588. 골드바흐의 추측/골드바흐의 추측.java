import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] arr = new boolean[1000001];
        arr[0] = arr[1] = true;

        for (int i = 2; i < arr.length; i++) {
            if (arr[i]) continue;
            for (int j = i * 2; j < arr.length; j += i) {
                arr[j] = true;
            }
        }

        int inputNum = 1;
        while ((inputNum = Integer.parseInt(br.readLine())) != 0) {
            int tmp1 = Integer.MAX_VALUE;
            int tmp2 = Integer.MAX_VALUE;
            for (int i=0; i<=inputNum; i++) {
                tmp1 = inputNum - i;
                tmp2 = i;
                if (!arr[tmp1] && !arr[tmp2]) {
                    sb.append(inputNum + " = " + tmp2 + " + " + tmp1).append("\n");
                    break;
                }
            }
            if (tmp1 == 0) sb.append("Goldbach's conjecture is wrong.").append("\n");
        }

        System.out.println(sb);
    }
}