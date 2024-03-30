import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int numLength = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        // A진법을 10진법으로 바꾸고 10진법을 B진법으로 바꿔서 출력하면 됨.
        int decimal = 0;
        for(int i=numLength-1; i>=0; i--) {
            decimal += toDecimal(Integer.parseInt(st.nextToken()), a, i);
        }

        // 10진법을 B진법으로 바꾸기
        String answer = toB(decimal, b);
        if (answer.charAt(0) == '0') answer = answer.substring(2);
        System.out.println(answer);
    }

    private static int toDecimal(int n, int a, int idx) {
        return (int) (n * Math.pow(a, idx));
    }

    private static String toB(int decimal, int b) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        // decimal을 b로 계속 나눠줌
        while (decimal > 0) {
            int reminder = decimal % b;
            list.add(reminder);
            decimal /= b;
        }

        for (int i=list.size()-1; i>= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }
        return sb.toString().trim();
    }
}
