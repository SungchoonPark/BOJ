import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static long[] mem = new long[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Arrays.fill(mem, -1);
        mem[0] = 0;
        mem[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibo(i);
        }
        System.out.println(fibo(n));
    }

    private static long fibo(int n) {
        if (mem[n] != -1) return mem[n];
        return mem[n] = mem[n-2] + mem[n-1];
    }
}


