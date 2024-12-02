import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        Set<String> stack = new HashSet<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.equals("ENTER")) {
                result += stack.size();
                stack = new HashSet<>();
                continue;
            }
            stack.add(input);
        }

        result += stack.size();

        System.out.println(result);
    }
}