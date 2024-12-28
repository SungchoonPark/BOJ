import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static long n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Long.parseLong(br.readLine());
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());

            while(!isPrime(num)) {
                num++;
            }
            sb.append(num).append("\n");
        }
        System.out.print(sb);
    }

    private static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        
        boolean flag = false;
        long sqrt = (long) Math.sqrt(n);
        for(long i = 2; i<=sqrt; i++) {
            if (n % i == 0) {
                flag = true;
                break;
            }
        }

        return !flag;
    }
}