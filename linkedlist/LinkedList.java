import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    public static Node convertArrayToLL(List<Integer> arr) {
        Node head = new Node(arr.get(0));
        Node mover = head;

        for (int i = 1; i < arr.size(); i++) {
            Node temp = new Node(arr.get(i));
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static int linkedListLength(Node head) {
        Node temp = head;
        int length = 0;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    public static Node deleteHead(Node head) {
        if (head == null)
            return head;
        return head.next;
    }

    public static Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node deleteByPosition(Node head, int pos) {
        if (head == null)
            return head;

        if (pos == 1) {
            return head.next;
        }

        int count = 1;
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if (count == pos) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
            count++;
        }

        return head;
    }

    public static Node deleteByElement(Node head, int ele) {
        if (head == null)
            return head;

        if (head.data == ele) {
            return head.next;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if (temp.data == ele) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    public static Node insertHead(int val, Node head) {
        Node temp = new Node(val);
        temp.next = head;
        return temp;
    }

    public static Node insertAtEnd(int val, Node head) {
        if (head == null) {
            return new Node(val);
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        Node newNode = new Node(val);
        temp.next = newNode;
        return head;
    }

    public static Node insertAtPosition(int val, Node head, int position) {
        if (head == null || position < 1) {
            return head;
        }

        if (position == 1) {
            Node temp = new Node(val);
            temp.next = head;
            return temp;
        }

        Node temp = head;
        int count = 1;

        while (temp != null) {
            if (count == position - 1) {
                Node newNode = new Node(val);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
            count++;
        }

        return head;
    }

    public static Node reverseLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prevNode = head;
        Node currNode = head.next;

        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prevNode;

        return head;
    }

    public static Node deleteNthFromEnd(Node head, int length, int n) {
        if (head == null || n > length) {
            return head;
        }

        int positionFromStart = (length - n) + 1;

        if (positionFromStart == 0) {
            return head.next;
        }

        Node current = head;

        for (int i = 1; i < positionFromStart - 1; i++) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            arr.add(i);
        }

        Node head = convertArrayToLL(arr);
        int length = linkedListLength(head);

        // Example operations
        head = deleteNthFromEnd(head, length, 4);
        print(head);
    }
}