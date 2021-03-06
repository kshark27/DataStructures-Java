// Singly Linked List

/**
 * Created by kartik on 20/05/16.
 */
public class LinkedList {

    Node head = null;
    Node tail = null;
    int size = 0;

    public static void main(String[] args) {

        LinkedList l = new LinkedList();

        for (int i = 1; i <= 5; i++) {
            l.append(i);
        }

        //Printing linked list
        l.traverseList(l);
        System.out.print("Linked List size: ");
        l.display(l.getListSize());

        //deleting a node with a particular value
        l.delete(4);
        l.traverseList(l);
        System.out.print("Linked List size : ");
        l.display(l.getListSize());

        //inserting a node after a perticular node
        l.insertAfter(3,4);
        l.traverseList(l);
        System.out.print("Linked List size : ");
        l.display(l.getListSize());


    }

    /**
     * Print the data value
     *
     * @param data
     */
    public void display(int data) {
        System.out.println(data);
    }

    /**
     * Appending a linked list with a tail | time complexity - O(1)
     *
     * @param data
     */
    public void appendFast(int data) {
        if (tail == null) {
            head = new Node(data);
            display(head.data);
            tail = head;
        } else {
            tail.next = new Node(data);
            tail = tail.next;
            display(tail.data);

        }
        System.out.println("Adding element "+data);

    }

    /**
     * Appending a linked list without a tail | Time complexity - O(n)
     *
     * @param data
     */
    public void append(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = new Node(data);
        }
        System.out.println("Adding element "+data);
    }

    /**
     * Insert a node after a particular data value
     * @param dataNode
     * @param data
     */
    public void insertAfter(int dataNode,int data){
        if (head != null) {
            Node n = head;
            Node previousNode = new Node(data);
            while (n.next != null) {
                n = n.next;
                if (n.data == dataNode) {
                    previousNode.next=n.next;
                    n.next = previousNode;
                }
            }

            System.out.println("Adding element "+data);
        }
    }

    /**
     * delete a node with a particular data value
     *
     * @param data
     */
    public void delete(int data) {
        if (head != null) {
            Node n = head;
            while (n.next != null) {
                Node pn = n;
                n = n.next;
                if (n.data == data) {
                    pn.next = n.next;
                    n = pn;
                }
            }
        }

        System.out.println("Deleting element "+data);

    }

    /**
     * traverse the given linked list
     *
     * @param list
     */
    public void traverseList(LinkedList list) {
        size = 0;
        if (list.head != null) {
            Node n = head;
            while (n.next != null) {
                size++;
                // to display the traversed element
                display(n.data);
                n = n.next;
            }
            // to display the last element
            display(n.data);
        }
    }

    /**
     * get Linked list size
     *
     * @return
     */
    public int getListSize() {
        return size + 1;
    }


}

// Node class

class Node {

    public int data;
    public Node next = null;

    public Node(int data) {
        this.data = data;
    }

}
