import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = Integer.parseInt(br.readLine());
        long sum = 0;
        
        long tmp = num + 1;
        
        for(int i=1; i<=num-1; i++) {
            sum = sum + (tmp*i);
        }

        System.out.println(sum);
    }
}

