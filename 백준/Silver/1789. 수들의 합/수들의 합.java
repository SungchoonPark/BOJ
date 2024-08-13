import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());
        long result = 0;
        long sum = 0;

        for (int i = 1; ; i++) {
            sum += i;
            if (sum > s) {
                break;
            }
            result++;
        }

        System.out.println(result);
    }
}