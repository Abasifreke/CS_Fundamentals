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
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode rightHead = getMiddle(head);
        ListNode reversedHead = reverse(rightHead);
        mergeLists(head, reversedHead);
    }
    
    private ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        // 1, 2, 3, 4, 5
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }   

    private ListNode reverse(ListNode node){
        if(node == null || node.next == null) return node;

        ListNode prev = null;
        ListNode curr = node;

        while(curr != null){
            ListNode nextCurr = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = nextCurr;
        }

        return prev;
    }

    private void mergeLists(ListNode first, ListNode second){

        while(first != null && second != null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            
            first = firstNext;
            second = secondNext;
        }

    }
}