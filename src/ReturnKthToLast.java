public class ReturnKthToLast {

    /*
     * takes in head of linked list and returns the kth element from the end of the
     * linked list
     */
    public static Node getKthToLast(Node head, int k) {
        Node node = head;
        Node kthFromN = null;
        int n = 0;

        // ask if k can be negative. and if so then what? loop around?
        if (k < 0) {
            return null;
        }

        while (node != null) {
            if (n == k) {
                kthFromN = head;
            } else if (n > k) {
                kthFromN = kthFromN.next;
            }

            n++;
            node = node.next;
        }
        
        return kthFromN;
    }

    // alternatively, go through list once to get length
    // then go through list second time with counter to get element at length - k -1

    public static void main(String[] args) {
        Node head = new Node("J");
        Node b = new Node("b");
        Node c = new Node("a");
        Node d = new Node("s");
        Node e = new Node("i");
        Node f = new Node("f");
        Node g = new Node("r");
        Node h = new Node("e");
        Node i = new Node("k");
        Node j = new Node("e");

        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;

        System.out.println(getKthToLast(head, 11));

    }
}
