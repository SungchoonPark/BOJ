import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String pwd = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for (char ch : pwd.toCharArray()) {
                if (ch == '<') {
                    if (iter.hasPrevious()) iter.previous();
                } else if (ch == '>') {
                    if (iter.hasNext()) iter.next();
                } else if (ch == '-') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                } else {
                    iter.add(ch);
                }
            }
            for (char ch : list) {
                sb.append(ch);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}