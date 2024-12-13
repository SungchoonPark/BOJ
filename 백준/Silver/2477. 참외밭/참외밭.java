import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 1m^2당 참외 개수 입력

        int maxW = 0, maxH = 0;
        int[] arr = new int[6]; // 방향 저장
        int[] value = new int[6]; // 길이 저장

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()); // 방향
            int len = Integer.parseInt(st.nextToken()); // 길이
            arr[i] = dir;
            value[i] = len;

            // 최대 가로 및 세로 길이 계산
            if ((dir == 1 || dir == 2) && len > maxW) maxW = len;
            if ((dir == 3 || dir == 4) && len > maxH) maxH = len;
        }

        // 작은 사각형 계산
        int tmpW = 0, tmpH = 0;
        for (int i = 0; i < 6; i++) {
            // 현재 방향과 2칸 뒤 방향 비교 (이어지는 작은 사각형)
            if (arr[i] == arr[(i + 2) % 6] && arr[(i + 1) % 6] == arr[(i + 3) % 6]) {
                tmpW = value[(i + 1) % 6];
                tmpH = value[(i + 2) % 6];
                break;
            }
        }

        // 전체 면적 계산
        int total = maxW * maxH;
        int tmp = tmpW * tmpH;
        int result = (total - tmp) * n;

        System.out.println(result);
    }
}