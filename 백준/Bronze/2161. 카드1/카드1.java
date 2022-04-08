import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=num; i++) {
            queue.add(i);
        }

        while(queue.size() != 1) {
            int i = queue.poll();
            System.out.printf("%d ", i);

            int j = queue.poll();
            queue.add(j);
        }

        System.out.printf("%d", queue.poll());
    }
}

