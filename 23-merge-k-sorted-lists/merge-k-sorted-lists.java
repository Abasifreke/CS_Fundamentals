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
    public ListNode mergeKLists(ListNode[] nodes) {

        if(nodes == null || nodes.length == 0){
            return null;
        }

        if(nodes.length == 1){
            return nodes[0];
        }

        // a and b refer to an int[]{c, d} where c is the list head, and d is the list it belongs to.
        PriorityQueue<Pair<ListNode, Integer>> kListQ = new PriorityQueue<>((a, b) -> a.getKey().val - b.getKey().val);
        ListNode dummyHead = new ListNode();
        ListNode tail = new ListNode();
        tail.next = dummyHead;

        for(int i = 0; i < nodes.length; i++){
            ListNode ithNode = nodes[i];
            if(ithNode == null) continue;

            kListQ.offer(new Pair<>(ithNode, i));
            nodes[i] = ithNode.next;
        }

        while(!kListQ.isEmpty()){
            Pair<ListNode, Integer> curr = kListQ.poll();
            int currIndex = curr.getValue();

            if(nodes[currIndex] != null){
                kListQ.offer(new Pair<>(nodes[currIndex], currIndex));
                nodes[currIndex] = nodes[currIndex].next;
            }

            ListNode currNode = curr.getKey();
            tail.next.next = currNode;
            currNode.next = tail;
            tail.next = currNode;
        }

        tail.next.next = null;
        return dummyHead.next;
    }
}