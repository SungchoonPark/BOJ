import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;
    static boolean[] isPrimes = new boolean[30_000_000];
    static List<Integer> primes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        primes = new ArrayList<>();
        primes.add(-1);

        erathos();

        System.out.println(primes.get(n));
    }

    private static void erathos() {
        Arrays.fill(isPrimes, true);

        for(int i=2; i<=isPrimes.length / 2; i++) {
            if (!isPrimes[i]) continue;
            primes.add(i);
            for(int j = i + i; j < isPrimes.length; j += i) {
                isPrimes[j] = false;
            }
        }

    }


}