import java.util.*;

class MyCircularQueue {
    Deque<Integer> circularQueue;
    int size;

    public MyCircularQueue(int k) {
        circularQueue = new ArrayDeque<>();
        size = k;
    }
    
    public boolean enQueue(int value) {
        if(this.isFull()) {
            return false; 
        }

        circularQueue.addLast(value);
        return true;
    }
    
    public boolean deQueue() {
        if(this.isEmpty()) {
            return false;
        }

        circularQueue.pollFirst();
        return true;
    }
    
    public int Front() {      
        if(this.isEmpty()) {
            return -1;
        }
        return circularQueue.peekFirst();
    }
    
    public int Rear() {
        if(this.isEmpty()) {
            return -1;
        }
        return circularQueue.peekLast();
    }
    
    public boolean isEmpty() {
        return circularQueue.isEmpty();
    }
    
    public boolean isFull() {
        return circularQueue.size() == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */