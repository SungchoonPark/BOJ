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

        String s = "";
        while ((s = br.readLine()) != null) {
            int up = 0;
            int low = 0;
            int num = 0;
            int space = 0;
            for (char c : s.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    up++;
                } else if (Character.isLowerCase(c)) {
                    low++;
                } else if (Character.isDigit(c)) {
                    num++;
                } else if (c == ' ') {
                    space++;
                }
            }
            sb.append(low + " ").append(up + " ").append(num + " ").append(space + " ").append("\n");
        }
        System.out.println(sb);

    }
}