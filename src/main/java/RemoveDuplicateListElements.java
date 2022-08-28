/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RemoveDuplicateListElements {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null)
            return head;
        ListNode pointer1 = head;
        ListNode pointer2 =head.next;

        while (pointer2 != null){
            if (pointer1.val == pointer2.val){
                pointer1.next = pointer2.next;
                pointer2 = pointer2.next;
            }
            else {
                pointer1 = pointer2;
                pointer2 = pointer2.next;
            }


        }
        return head;
    }
}