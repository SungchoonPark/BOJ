import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int result = 0;
        int tmp = 1;
        int a = 10;

        for(int i=1; i<=num; i++) {
            if(i %a == 0) {
                tmp++;
                a *= 10;
            }
            result+=tmp;
        }

        System.out.println(result);




    }
}
