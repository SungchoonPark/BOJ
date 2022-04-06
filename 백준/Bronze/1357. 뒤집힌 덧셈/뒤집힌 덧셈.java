import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder(st.nextToken());
        int num1 = Integer.parseInt(sb.reverse().toString());
        StringBuilder new_sb = new StringBuilder(st.nextToken());
        int num2 = Integer.parseInt(new_sb.reverse().toString());
        
        int result = num1 + num2;

        String s = Integer.toString(result);
        StringBuilder stB = new StringBuilder(s);
        System.out.println(Integer.parseInt(stB.reverse().toString()));

    }
}

