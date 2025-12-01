import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int target = n;
        int result = 0;

        for(int i=n-1; i>= 0; i--) {
            if (arr[i] == target) {
                target--;
            } else {
                result++;
            }
        }

        System.out.print(result);
    }

}