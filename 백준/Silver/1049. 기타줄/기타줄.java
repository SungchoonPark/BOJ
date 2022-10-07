import javax.management.BadBinaryOpValueExpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int stringNum = Integer.parseInt(st.nextToken());
        int brandNum = Integer.parseInt(st.nextToken());

        int[] unit = new int[brandNum];
        int[] pack = new int[brandNum];

        for (int i = 0; i < brandNum; i++) {
            st = new StringTokenizer(br.readLine());

            pack[i] = Integer.parseInt(st.nextToken());
            unit[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(unit);
        Arrays.sort(pack);

        int a, b, c;

        if (stringNum % 6 != 0) {
            a = pack[0] * ((stringNum / 6) + 1);
        } else {
            a = pack[0] * (stringNum / 6);
        }
        b = unit[0] * stringNum;
        c = (pack[0] * (stringNum / 6)) + (unit[0] * (stringNum % 6));

        int minPrice = Math.min(a, Math.min(b, c));
        System.out.println(minPrice);
    }
}