import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String binaryInput = br.readLine();

        int length = binaryInput.length();

        int remainder = length % 3;
        if (remainder != 0) {
            for (int i = 0; i < 3 - remainder; i++) {
                binaryInput = "0" + binaryInput;
            }
            length += 3 - remainder;
        }

        StringBuilder octalOutput = new StringBuilder();
        for (int i = 0; i < length; i += 3) {
            String triplet = binaryInput.substring(i, i + 3);
            int decimalValue = Integer.parseInt(triplet, 2); // 2진수를 10진수로 변환
            octalOutput.append(Integer.toOctalString(decimalValue)); // 10진수를 8진수로 변환하여 추가
        }

        System.out.println(octalOutput);
    }
}
