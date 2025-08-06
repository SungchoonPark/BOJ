import java.util.*;

//  public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }

class Solution {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> dq = new LinkedList<>();

        ListNode node = head;
        while(node != null) {
            dq.add(node.val);
            node = node.next;
        }

        while(!dq.isEmpty() && dq.size() > 1) {
            if(dq.pollFirst() != dq.pollLast()) {
                return false;
            }
        }

        return true;
    }
}