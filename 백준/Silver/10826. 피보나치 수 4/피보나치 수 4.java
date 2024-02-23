import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static BigInteger[] mem = new BigInteger[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n));
    }

    private static BigInteger fibo(int n) {
        if (mem[n] != null) return mem[n];
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;
        return mem[n] = fibo(n-2).add(fibo(n-1));
    }
}


