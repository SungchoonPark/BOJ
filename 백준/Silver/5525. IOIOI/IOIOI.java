import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int len = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int count = 0; // 패턴 일치 개수
        int result = 0; // 최종 패턴 수
        int i = 1;

        while (i < len - 1) {
            if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
                count++;
                if (count == n) {
                    result++;
                    count--; // 다음 패턴을 위해 count 줄이기
                }
                i += 2; // IOI 패턴을 찾았으니 2칸 이동
            } else {
                count = 0; // 패턴이 깨지면 count 초기화
                i++;
            }
        }

        System.out.println(result);
    }
}