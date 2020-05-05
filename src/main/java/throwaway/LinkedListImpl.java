package throwaway;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}


public class LinkedListImpl {
    private Node head = null;

    public void insert(int data){
        Node newNode = getNewNode(data);
        if(head == null){
            head = newNode;
            return;
        }

        Node tempNode = head;
        while(tempNode.next != null){
            tempNode = tempNode.next;
        }
        tempNode.next = newNode;

    }

    private Node getNewNode(int data) {
        Node newNode = new Node(data);
        newNode.setNext(null);
        return newNode;
    }

    public void insert(int data, int position){
        Node temp = head;
        Node newNode = getNewNode(data);

        if(position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        for (int i=0; i<position-1; i++){
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void displayAll(){
        Node temp = head;
        while(temp != null) {
            System.out.println(temp);
            temp = temp.getNext();

        }
    }

    public static void main(String[] args) {
        LinkedListImpl ll = new LinkedListImpl();
        ll.insert(10);
        ll.insert(20);
        ll.insert(30);
        ll.insert(40);

        ll.insert(1000, 2);
        ll.displayAll();
    }
}
