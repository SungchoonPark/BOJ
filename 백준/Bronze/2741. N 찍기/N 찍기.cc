import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(br.readLine());

        for(int i =1; i<=value; i++) {
            if(i==value) {
                System.out.printf("%d", i);

            } else {
                System.out.println(i);
            }
        }
    }
}
