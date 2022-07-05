import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = new long[101];
        int testNum = Integer.parseInt(br.readLine());

        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 2;
        for(int i=5; i<101; i++) {
            arr[i] = arr[i-5] + arr[i-1];
        }
        for(int i=0; i<testNum; i++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(arr[n-1]);
        }

    }
}
