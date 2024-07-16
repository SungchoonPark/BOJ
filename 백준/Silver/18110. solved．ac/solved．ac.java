import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        int cutNum = getCutNum(n);

        int sum = 0;
        for (int i = cutNum; i < n - cutNum; i++) {
            sum += list.get(i);
        }
        int t = n - (cutNum * 2);
        int round = (int) Math.round((double)sum / t);
        System.out.println(round);
    }

    private static int getCutNum(int num) {
        return (int) Math.round(num * 0.3 / 2);
    }
}
