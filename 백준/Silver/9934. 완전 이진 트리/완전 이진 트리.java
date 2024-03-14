import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int h;
    static int[] nodes;
    static StringBuffer[] company;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        h = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int size = st.countTokens();
        nodes = new int[size];
        company = new StringBuffer[h];

        for (int i=0; i<h; i++) {
            company[i] = new StringBuffer();
        }

        for (int i = 0; i < size; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }

        search(0, size-1, 0);

        for(int i=0; i<h; i++) {
            System.out.println(company[i].toString());
        }

    }

    private static void search(int start, int end, int level) {
        if (level == h) return;

        int middle = (start + end) / 2;
        company[level].append(nodes[middle] + " ");

        search(start, middle - 1, level+1);
        search(middle+1, end, level+1);
    }

}

