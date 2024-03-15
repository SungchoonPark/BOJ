import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int allPrice = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());

            int price = Integer.parseInt(st.nextToken());
            int productNum = Integer.parseInt(st.nextToken());

            sum = sum + price * productNum;
        }

        if (sum == allPrice) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}