import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[] isDown;
    static List<Long> downList;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        downList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dfs("0", String.valueOf(i));
        }
        Collections.sort(downList);

        if (n >= downList.size()) System.out.println(-1);
        else System.out.print(downList.get(n));
    }

    private static void dfs(String num, String plusNum) {
        String tmp = num + plusNum;
        long longValue = Long.parseLong(tmp);
        int i1 = Integer.parseInt(plusNum);
        downList.add(longValue);

        for (int i = i1 - 1; i >= 0 ; i--) {
            String nextNum = tmp + i;
            long tmpNum = Long.parseLong(nextNum);
            if (tmpNum <= 9876543210L) dfs(tmp ,String.valueOf(i));
        }
    }

}
