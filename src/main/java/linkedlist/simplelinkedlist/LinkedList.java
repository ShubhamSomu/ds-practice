package linkedlist.simplelinkedlist;

public class LinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public static void print() {
        if (head == null) {
            System.out.println("No elements found");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "\t");
            currentNode = currentNode.next;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    public static void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Prev Node can't be null");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;

    }

    public void insertAfter(int prevData, int data) {
        Node newNode = new Node(data);
        Node currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.data == prevData) {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                return;
            }
            currentNode = currentNode.next;
        }

        System.out.println(prevData + " not found.");
    }

    public void deleteNode(int key) {
        Node currentNode = head, prev = null;

        // key is head
        if (currentNode != null && currentNode.data == key) {
            head = currentNode.next;
            return;
        }

        while (currentNode != null && currentNode.data != key) {
            prev = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            System.out.println(key + "not Found");
            return;
        }

        prev.next = currentNode.next;
    }

    public void deleteNodeAtIndex(int index) {

        if (head == null) {
            return;
        }
        Node currentNode = head;
        if (index == 0) {
            head = currentNode.next;
        }

        for (int i = 0; currentNode != null && i < index - 1; i++) {
            currentNode = currentNode.next;
        }

        if (currentNode == null || currentNode.next == null) {
            System.out.println(index + " not found.");
        }
        // current node.next = node to delete
        Node prev = currentNode.next.next;
        currentNode.next = prev;
    }

    public void deleteLinkedList() {
        head = null;
    }

    public int length() {
        int counter = 0;
        Node currentNode = head;
        while (currentNode != null) {
            counter++;
            currentNode = currentNode.next;
        }
        return counter;
    }

    public void printMiddleSlowFast() {
        Node tortoise = head;
        Node hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }

        System.out.println("\n \t Middle Element is: " + tortoise);
    }

    public int findElement(int data) {
        Node currentNode = head;
        int index = 0;
        boolean status = false;
        while (currentNode != null) {
            if (currentNode.data == data) {
                status = true;
                break;
            } else {
                index++;
                currentNode = currentNode.next;
            }
        }

        if (!status) {
            return -1;
        }
        return index;
    }

    public int findNthElement(int index) {
        Node currentNode = head;
        int count = 1;

        while (currentNode != null) {
            if (count == index) {
                return currentNode.data;
            }
            count++;
            currentNode = currentNode.next;
        }
        return -1;
    }

    public int frequencyOfTerm(int searchTerm) {
        Node currentNode = head;
        int counter = 0;

        while (currentNode != null) {
            if (currentNode.data == searchTerm) {
                counter++;
            }
            currentNode = currentNode.next;
        }
        return counter;
    }

    public int findNthElementFromEnd(LinkedList linkedList, int index) {
        int length = linkedList.length();
        Node currentNode = head;
        for (int i = 1; i < length - index + 1; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.push(4);
        linkedList.push(18);
        linkedList.push(20);
        linkedList.push(54);
        linkedList.push(71);
        linkedList.append(3);

        linkedList.insertAfter(2, 5);
        linkedList.insertAfter(4, 36);
        System.out.println("\n -> before delete <-");
        print();
        linkedList.deleteNodeAtIndex(1);
        System.out.println("\n -> after delete <-");
        print();

        /*System.out.println("\n -> Delete Linked List <-");
        linkedList.deleteLinkedList();
        print();*/

        System.out.println("\n Length of LL");
        System.out.println(linkedList.length());

        System.out.println("\n Find element ");
        int searchElement = 10;
        System.out.println("Element " + searchElement + " found at index: " + linkedList.findElement(searchElement));

        System.out.println("\n Find Nth Element");
        int nthElement = 2;
        System.out.println("Data of index " + nthElement + " is " + linkedList.findNthElement(3));

        System.out.println("\n Nth Element from end");
        int nthFromEnd = 3;
        System.out.println(nthFromEnd + " element from end is: " + linkedList.findNthElementFromEnd(linkedList, nthFromEnd));

        linkedList.printMiddleSlowFast();

        int frequencySearchTerm = 4;
        System.out.println(String.format("Item %d occured %d times",
                                         frequencySearchTerm,
                                         linkedList.frequencyOfTerm(frequencySearchTerm)));

/*
        *** *** Lay man way *** ***
        linkedList.head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        linkedList.head.next = node2;
        node2.next = node3;
        * */
    }
}
