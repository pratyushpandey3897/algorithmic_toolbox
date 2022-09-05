import java.util.HashMap;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        HashMap<Object, Object> map = new HashMap<Object, Object>();
        Boolean cycleFlag = false;
        if (head == null)
            return false;
        while(!map.containsKey(head)){
            map.put(head, head.next);

            head = head.next;
            if (head == null){
                return cycleFlag;
            }
        }

        cycleFlag = true;

        return cycleFlag;
    }
}