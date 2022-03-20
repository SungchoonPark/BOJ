import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[10];

        int[] inputNum = new int[3];
        for(int i = 0; i < 3; i++) {
            inputNum[i] = Integer.parseInt(br.readLine());
        }

        int result = inputNum[0] * inputNum[1] * inputNum[2];

        String num = Integer.toString(result);

        for(int i = 0; i < num.length(); i++) {
            String tmp = num.substring(i, i+1);
            count[Integer.parseInt(tmp)]++;
        }

        for (int j : count) {
            System.out.println(j);
        }

    }
}
