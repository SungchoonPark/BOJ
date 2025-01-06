import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Map to store color values and multipliers
        Map<String, Integer> valueMap = new HashMap<>();
        Map<String, Long> multiplierMap = new HashMap<>();
        
        valueMap.put("black", 0); multiplierMap.put("black", 1L);
        valueMap.put("brown", 1); multiplierMap.put("brown", 10L);
        valueMap.put("red", 2); multiplierMap.put("red", 100L);
        valueMap.put("orange", 3); multiplierMap.put("orange", 1000L);
        valueMap.put("yellow", 4); multiplierMap.put("yellow", 10000L);
        valueMap.put("green", 5); multiplierMap.put("green", 100000L);
        valueMap.put("blue", 6); multiplierMap.put("blue", 1000000L);
        valueMap.put("violet", 7); multiplierMap.put("violet", 10000000L);
        valueMap.put("grey", 8); multiplierMap.put("grey", 100000000L);
        valueMap.put("white", 9); multiplierMap.put("white", 1000000000L);
        
        String one = br.readLine();
        String two = br.readLine();
        String three = br.readLine();
        
        long result = (valueMap.get(one) * 10L + valueMap.get(two)) * multiplierMap.get(three);
        System.out.println(result);
    }
}