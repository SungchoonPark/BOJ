import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        double[] a = new double[num];

        StringTokenizer st = new StringTokenizer(br.readLine());

        double maxNum = 0;
        int index = 0;
        while(st.hasMoreTokens()) {
            double tmp = Double.parseDouble(st.nextToken());
            a[index] = tmp;
            index++;
            if(tmp > maxNum) {
                maxNum = tmp;
            }
        }

        double sum = 0;
        for (double v : a) {
            sum += v / maxNum * 100;
        }

        System.out.println((sum / a.length));

    }
}
