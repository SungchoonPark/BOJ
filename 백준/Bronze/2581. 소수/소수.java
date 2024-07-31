import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    static boolean[] isPrime = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        erathos();
        
        int min = 0;
        int sum = 0;
        boolean isFirst = true;
        for (int i = a; i <= b; i++) {
            if (isPrime[i]) {
                if (isFirst) {
                    min = i;
                    isFirst = false;
                }
                list.add(i);
                sum += i;
            }
        }
        if (sum == 0 && min == 0) {
            System.out.println(-1);
            return;
        }
        sb.append(sum).append("\n").append(min);
        System.out.println(sb);
    }

    private static void erathos() {
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < 10000; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j <= 10000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
