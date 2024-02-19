import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static long n, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());

        binarySearch();
        System.out.println(answer);
    }

    private static void binarySearch() {
        long start = 0;
        long end = n;

        while (end >= start) {
            long num = (start + end) / 2;
            if (Math.pow(num, 2) >= n) {
                answer = num;
                end = num - 1;
            } else {
                start = num + 1;
            }
        }
    }
}


