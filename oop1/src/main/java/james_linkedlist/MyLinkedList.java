package james_linkedlist;

public class MyLinkedList {
    private  Node head;
    private  int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;
    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public Node get(int index){
        Node temp=head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void add(int index, Object data) {
        Node temp = head;
        Node holder;

        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;

        // holder = ?, temp = ?
        // Dat: temp N-1, holder: N0
        // Duc: temp N0, holder N1
        // Phuc: temp N-3, holder N-2
        Node newNode = new Node(data);
        temp.next = newNode;
//        temp.next.next = holder;
        newNode.next = holder;
        numNodes++;
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(1);
        myLinkedList.addFirst(0);
        myLinkedList.addFirst(-1);
        myLinkedList.addFirst(-2);
        myLinkedList.addFirst(-3);

        myLinkedList.add(3, 100);
    }
}
