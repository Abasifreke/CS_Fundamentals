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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        int count = 1;
        ListNode runner = head;
        ListNode nth = null;
        ListNode prev = null;

        // increment count till n.
        while(runner.next != null && count != n){
            runner = runner.next;
            count++;
        }

        nth = head;
        if(runner.next == null) return nth.next;

        // start moving in concert
        while(runner.next != null){
            runner = runner.next;
            prev = nth;
            nth = nth.next;
        }

        prev.next = nth.next;
        nth.next = null;
        return head;

        
    }
}