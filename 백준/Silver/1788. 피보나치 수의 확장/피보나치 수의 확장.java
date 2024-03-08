import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static long[] mem = new long[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int absN = Math.abs(n);

        Arrays.fill(mem, -1);
        mem[0] = 0;
        mem[1] = 1;
        for (int i = 2; i <= absN; i++) {
            mem[i] = (mem[i - 1] + mem[i - 2]) % 1_000_000_000;
        }

        if (n > 0) {
            System.out.println(1);
            System.out.println(mem[absN]);
        } else if (n == 0) {
            System.out.println(0);
            System.out.println(0);
        } else {
            if (absN % 2 == 0) System.out.println(-1);
            else System.out.println(1);
            System.out.println(mem[absN]);
        }
    }
}