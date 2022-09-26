import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 자연수 n이 들어오면 n보다 크고 2n보다 작거나 같은 소수 출력

        // 에라토스테네스의 채로 미리 소수 다 구해놓기.
        boolean[] arr = new boolean[250000];
        arr[0] = true;
        arr[1] = true;
        for(int i=2; i<=Math.sqrt(250000); i++) {
            for(int j=i*i; j<250000; j+=i) {
                arr[j] = true;
            }
        }

        while(true) {
            int n = Integer.parseInt(br.readLine());
            int result = 0;
            if(n==0) break;

            for(int i=n+1; i<=n*2; i++) {
                if(!arr[i]) {
                    result++;
                }
            }
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}