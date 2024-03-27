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

        String s= br.readLine();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || c == ' ') {
                sb.append(c);
            } else if (Character.isAlphabetic(c)){
                if (Character.isUpperCase(c)) {
                    int newC = c + 13;
                    if (newC > 90) sb.append((char) (newC - 26));
                    else sb.append((char)newC);
                } else {
                    int newC = c + 13;
                    if (newC > 122) sb.append((char) (newC - 26));
                    else sb.append((char)newC);
                }
            }
        }
        System.out.println(sb);

    }
}