import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int min = search(n, 0);
        if (min <= k) {
            System.out.println("minigimbob");
        } else {
            System.out.println("water");
        }

    }


    private static int search(int i, int cnt) {
        if (i < 3) return cnt + i;
        if (i % 3 == 0) return  search(i / 3 * 2, cnt + 1);
        else if ((i-1)%3 == 0) return search((i-1)/3*2+1, cnt + 1);
        else return search(i -1, cnt + 1);
    }
}