import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Integer> list = new ArrayList<>();
        int num = 42;

        for (int i = 0; i < 10; i++) {
            int tmp = (Integer.parseInt(br.readLine())) % 42;
            list.add(tmp);
        }

        List<Integer> newList = list.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(newList.size());

        br.close();
    }
}
