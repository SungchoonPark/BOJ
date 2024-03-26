import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        double[] arr = new double[27];
        int num = Integer.parseInt(br.readLine());
        Stack<Double> stack = new Stack<>();
        String s = br.readLine();

        for (int i = 0; i < num; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        for (char c : s.toCharArray()) {
            if (c >= 65 && c <= 90) {
                stack.push(arr[c - 'A']);
            } else {
                if (c == '+') {
                    Double a1 = stack.pop();
                    Double a2 = stack.pop();
                    stack.push(a2 + a1);
                } else if (c == '-') {
                    Double a1 = stack.pop();
                    Double a2 = stack.pop();
                    stack.push(a2 - a1);
                } else if (c == '*') {
                    Double a1 = stack.pop();
                    Double a2 = stack.pop();
                    stack.push(a2 * a1);
                } else if (c == '/') {
                    Double a1 = stack.pop();
                    Double a2 = stack.pop();
                    stack.push(a2 / a1);
                }
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}