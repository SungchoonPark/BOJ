import java.util.*;

class Solution {
    static PriorityQueue<Value> pq;
    static Value[] values;
    static int[] sArr;
    static int tmpI;
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        sort(data, col);
        values = new Value[data.length + 1];
        
        int a = 1;
        while(!pq.isEmpty()) {
            values[a++] = pq.poll();
        }
        
        sArr = new int[row_end - row_begin + 1];
        for(int i=row_begin; i<=row_end; i++) {
            calculateS(i);
        }

        return calculateXOR();
    }
    
    private static void sort(int[][] data, int col) {
        pq = new PriorityQueue<>((v1, v2) -> {
            if(v1.arr[col - 1] == v2.arr[col - 1]) {
                return v2.arr[0] - v1.arr[0];
            }
            return v1.arr[col - 1] - v2.arr[col - 1];
        });
        
        for(int i=0; i<data.length; i++) {
            pq.add(new Value(data[i]));
        }
    }   
    
    private static void calculateS(int i) {
        int tmp = 0;
        for(int a : values[i].arr) {
            tmp = tmp + (a % i);
        }
        sArr[tmpI++] = tmp;
    }
    
    private static int calculateXOR() {
        int tmp = sArr[0];
        for(int i=1; i < sArr.length; i++) {
           tmp ^= sArr[i];
        }
        
        return tmp;
    }
    
    static class Value {
        int[] arr;
        
        public Value(int[] arr) {
            this.arr = new int[arr.length];
            for(int i=0; i<arr.length; i++) this.arr[i] = arr[i];
        }
    }
}