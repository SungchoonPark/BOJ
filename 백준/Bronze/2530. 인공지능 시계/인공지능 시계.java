import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int hours = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());
        int seconds = Integer.parseInt(st.nextToken());
        int addSeconds = Integer.parseInt(br.readLine());

        // 초 더하기
        seconds += addSeconds;

        // 분으로 변환
        minutes += seconds / 60;
        seconds %= 60;

        // 시로 변환
        hours += minutes / 60;
        minutes %= 60;

        // 24시간 형식으로 변환
        hours %= 24;

        // 결과 출력
        sb.append(hours).append(" ").append(minutes).append(" ").append(seconds);
        System.out.println(sb);

        
    }
}