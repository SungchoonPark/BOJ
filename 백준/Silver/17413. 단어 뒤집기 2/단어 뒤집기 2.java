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

        boolean flag = false;
        String sTmp = "";
        for (int i = 0; i < input.length(); i++) {
            char tmp = input.charAt(i);

            if (tmp == '<') {
                flag = true;
                if (!sTmp.equals("")) {
                    sb.append(new StringBuilder(sTmp).reverse());
                    sTmp = "";
                }
                sb.append(tmp);
            } else if (tmp == '>') {
                sb.append(tmp);
                flag = false;

            } else {
                if (flag) {
                    sb.append(tmp);
                } else {
                    if (tmp == ' ') {
                        sb.append(new StringBuilder(sTmp).reverse()).append(' ');
                        sTmp = "";
                    } else {
                        sTmp += tmp;
                    }
                }
            }
        }

        if (sTmp != "") {
            sb.append(new StringBuilder(sTmp).reverse());
        }
        System.out.println(sb);
    }
}