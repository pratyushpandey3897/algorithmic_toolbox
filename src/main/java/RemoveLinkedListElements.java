
class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head==null) return null;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode current = prev;

        while (current.next!= null){
            if (current.next.val == val){
                current.next = current.next.next;

            }
            else{
                current = current.next;}

        }

        return prev.next;
    }
}