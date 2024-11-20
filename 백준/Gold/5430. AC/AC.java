import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String command = br.readLine();
            int len = Integer.parseInt(br.readLine());

            String arrayInput = br.readLine();
            Deque<Integer> deque = new ArrayDeque<>();

            // Parsing the input array
            if (len > 0) {
                String[] numbers = arrayInput.substring(1, arrayInput.length() - 1).split(",");
                for (String number : numbers) {
                    deque.add(Integer.parseInt(number.trim()));
                }
            }

            boolean isReversed = false;
            boolean error = false;

            for (char cmd : command.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed;
                } else if (cmd == 'D') {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (isReversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (error) {
                System.out.println("error");
            } else {
                StringBuilder result = new StringBuilder();
                result.append("[");

                while (!deque.isEmpty()) {
                    result.append(isReversed ? deque.removeLast() : deque.removeFirst());
                    if (!deque.isEmpty()) {
                        result.append(",");
                    }
                }

                result.append("]");
                System.out.println(result);
            }
        }
    }
}