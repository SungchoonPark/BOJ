import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int result = 2*s - a;
        System.out.println(result);
    }
}