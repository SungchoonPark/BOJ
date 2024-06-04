import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int maxCnt = 0;

        char[] arr = br.readLine().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') {
                for (int j = i - k; j <= i + k; j++) {
                    if (j >= 0 && j < arr.length && arr[j] == 'H') {
                        arr[j] = 'X';  // 햄버거를 먹음 표시
                        maxCnt++;
                        break;  // 한 번 햄버거를 먹으면 다음 사람으로 이동
                    }
                }
            }
        }

        System.out.println(maxCnt);
    }
}
