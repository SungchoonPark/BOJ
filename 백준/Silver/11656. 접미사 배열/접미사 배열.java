import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();

        String[] arr = new String[word.length()];

        for(int i=0; i<word.length(); i++) {
            arr[i] = word.substring(i);
        }

        Arrays.sort(arr);

        for (String s : arr) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
