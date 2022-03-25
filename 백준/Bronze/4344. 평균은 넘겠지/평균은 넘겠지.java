import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {

            double sum = 0;
            int index = 0;
            List<String> scoreList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                scoreList.add(st.nextToken());
                if (index > 0) {
                    sum += Double.parseDouble(scoreList.get(index));
                }
                index++;
            }

            double avg = sum / Double.parseDouble(scoreList.get(0));

            double good = 0;

            for (int k = 1; k < scoreList.size(); k++) {
                if (Double.parseDouble(scoreList.get(k)) > avg) {
                    good++;
                }
            }

            double result = good / Double.parseDouble(scoreList.get(0)) * 100;
            System.out.println(String.format("%.3f", result)+"%");
        }

    }
}

