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
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        int total = 0;
        for(int i=0; i< input.length(); i++) {
            char tmp = input.charAt(i);
            if (tmp == '(') {
                stack.push(tmp);
            } else {
                if (input.charAt(i-1) == '(') {
                    // 레이저인 경우
                    stack.pop();
                    total+= stack.size();
                } else {
                    // 쇠막대인 경우
                    stack.pop();
                    total ++;
                }
            }
        }

        System.out.println(total);
    }
}