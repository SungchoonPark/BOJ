import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long a= Integer.parseInt(br.readLine());
        long result = (a-2) * (a-1) * (a) / 6;
        System.out.println(result);
        System.out.println(3);
    }
}
