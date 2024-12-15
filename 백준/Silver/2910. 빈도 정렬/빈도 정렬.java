import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // LinkedHashMap으로 입력 순서를 유지하면서 빈도 카운트
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Map.Entry를 리스트로 변환하여 빈도 내림차순으로 정렬
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().equals(e1.getValue()) 
            ? 0 // 빈도가 같으면 순서를 유지 (LinkedHashMap의 삽입 순서 보장)
            : e2.getValue() - e1.getValue()); // 빈도 내림차순 정렬

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            int num = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb);
    }
}