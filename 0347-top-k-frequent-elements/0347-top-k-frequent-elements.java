import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Node> nodes = new PriorityQueue<>((n1, n2) -> n2.count - n1.count);
        
        for(int i=0; i<nums.length; i++) {
            int n = nums[i];
            int count = map.getOrDefault(n, 0);
            map.put(n, count + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            int key = entry.getKey();
            int value = entry.getValue();
            
            nodes.add(new Node(key, value));
        }

        int[] result = new int[k];
        for(int i=0; i<k; i++) {
            result[i] = nodes.poll().value;
        }
        return result;
    }

}

class Node {
    int value;
    int count;

    public Node(int value, int count) {
        this.value = value;
        this.count = count;
    }


}