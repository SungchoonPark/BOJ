import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int burgerCnt = Integer.parseInt(st.nextToken());
        int sideCnt = Integer.parseInt(st.nextToken());
        int drinkCnt = Integer.parseInt(st.nextToken());
        int beforePrice = 0;

        // Integer 배열로 선언
        Integer[] burgers = new Integer[burgerCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < burgerCnt; i++) {
            burgers[i] = Integer.parseInt(st.nextToken());
            beforePrice += burgers[i];
        }

        Integer[] sides = new Integer[sideCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sideCnt; i++) {
            sides[i] = Integer.parseInt(st.nextToken());
            beforePrice += sides[i];
        }

        Integer[] drinks = new Integer[drinkCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < drinkCnt; i++) {
            drinks[i] = Integer.parseInt(st.nextToken());
            beforePrice += drinks[i];
        }

        // 각 카테고리 내림차순 정렬
        Arrays.sort(burgers, Collections.reverseOrder());
        Arrays.sort(sides, Collections.reverseOrder());
        Arrays.sort(drinks, Collections.reverseOrder());

        sb.append(beforePrice).append("\n");

        // 세트 개수
        int minCnt = Math.min(burgerCnt, Math.min(sideCnt, drinkCnt));

        int setPrice = 0;
        // 할인받는 세트 구성
        for (int i = 0; i < minCnt; i++) {
            int price = burgers[i] + sides[i] + drinks[i];
            setPrice += (price * 9) / 10;  // price * 0.9 대신 안전한 정수 연산
        }

        // 남은 개별 항목들 더하기
        for (int i = minCnt; i < burgerCnt; i++) setPrice += burgers[i];
        for (int i = minCnt; i < sideCnt; i++) setPrice += sides[i];
        for (int i = minCnt; i < drinkCnt; i++) setPrice += drinks[i];

        sb.append(setPrice);

        System.out.print(sb);
    }
}