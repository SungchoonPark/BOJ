import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int maxIndex = 0;

        for(int i=0; i<9; i++) {
            int intNum = Integer.parseInt(br.readLine());

            if(intNum > max) {
                max = intNum;
                maxIndex = i+1;
            }

        }

        System.out.println(max);
        System.out.println(maxIndex);

    }
}
