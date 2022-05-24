import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int[][] arr = new int[8][2];
        int[] result = new int[5];

        for(int i=0; i<8; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[0], o1[0]);
            }
        });

        for(int i=0; i<5; i++) {
            sum += arr[i][0];
            result[i] = arr[i][1] + 1;
        }

        Arrays.sort(result);

        System.out.println(sum);
        for(int i=0; i<5; i++) {
            System.out.print(result[i] + " ");
        }
        




    }
}

