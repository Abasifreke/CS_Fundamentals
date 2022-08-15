public class LinkedListQs {

    static class Node {
        private Node next;
        private Node prev;
        private Object value;

        Node(Object _value) {
            value = _value;
        }
    }

    /**
     * Implement an algorithm to delete a node from the middle of singly linked List (SLL) given access to only that node
     */
    static void deleteNodeInSLL(Node nodeToDelete) {
        if(nodeToDelete.next == null){
            nodeToDelete = null;
        }else if(nodeToDelete.next.next == null){
            nodeToDelete.value = nodeToDelete.next.value;
            nodeToDelete.next = null;
        }else {
            Node nodeToDeletesNextNext = nodeToDelete.next.next;
            nodeToDelete.value = nodeToDelete.next.value;
            nodeToDelete.next = nodeToDeletesNextNext;
        }
    }


    /**
     *
     * @param head,tail
     * @return if a linked list (assuming a doubly linked list is a palindrome)
     */
    static boolean checkPalindrome(Node head, Node tail){
        if(head == null || head.next == null) return true;

        while(head != tail){
            if(head.value != tail.value) return false;

            head = head.next;
            tail = tail.prev;
        }

        return true;
    }

    static String toString(Node a) {

        Node current = a;
        StringBuffer sb = new StringBuffer("The List starting at this node is: ");
        while (current != null) {
            sb.append(current.value).append(", ");
            current = current.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        // region test deleteNodeInSLL
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('c');
        Node e = new Node('b');
        Node f = new Node('a');
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        b.prev = a;
        c.prev = b;
        d.prev = c;
        e.prev = d;
        f.prev = e;


//        deleteNodeInSLL(d);

        System.out.println(toString(a));
        System.out.println(checkPalindrome(a, e));
    }
}
