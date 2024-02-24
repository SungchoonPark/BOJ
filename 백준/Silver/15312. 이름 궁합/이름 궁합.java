import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static int[] alpha = {
            3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1
    };
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String he = br.readLine();
        String she = br.readLine();
        for (int i = 0; i < he.length(); i++) {
            list.add(alpha[he.charAt(i) - 65]);
            list.add(alpha[she.charAt(i) - 65]);
        }

        while (true) {
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                tmpList.add((list.get(i) + list.get(i + 1)) % 10);
            }

            list = tmpList;
            if (list.size() == 2) {
                System.out.println(list.get(0) + "" + list.get(1));
                break;
            }
        }
    }
}


