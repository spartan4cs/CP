class LinkListCreationDemo {

    public static void main(String[] args) {
        linkedlist l = new linkedlist();

        l.addFirst(20);
        l.addFirst(10);
        l.addLast(30);
        l.addLast(40);
        System.out.println(l.size());
        l.displayList();
        l.getAt(2);
        l.removeFirst();
        l.displayList();

        l.removeLast();
        l.displayList();
        l.addFirst(20);
        l.addFirst(10);
        l.addLast(30);
        l.addLast(40);
        l.displayList();
        l.removeAt(2);
        l.displayList();

    }
}

class linkedlist {

    private Node head;
    private Node tail;
    private int size;

    public linkedlist() {
        this.head = this.tail = null;
        this.size = 0;
    }

    private class Node {
        private int data;
        private Node next;

        public Node() {
            this.data = 0;
            this.next = null;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {

            this.data = data;
            this.next = next;
        }
    }// node end

    // addfirst
    // addlast
    // addAt

    public void addFirst(int val) {
        if (size() == 0) {
            Node n = new Node(val);
            this.head = this.tail = n;
            this.size++;
        } else {
            Node n = new Node(val);
            n.next = head;
            head = n;
            this.size++;
        }

    }

    public void addLast(int val) {
        if (size() == 0) {
            Node n = new Node(val);
            this.head = this.tail = n;
            this.size++;
        } else {
            Node n = new Node(val);
            tail.next = n;
            tail = n;
            this.size++;
        }
    }

    public void addAt(int val, int index) {

        if (index < 0 || index > this.size) {
            System.out.println("Invalid index");
            return;
        }

        if (size() == 0) {
            Node n = new Node(val);
            this.head = this.tail = n;
            this.size++;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node n = new Node(val);
            n.next = temp.next;
            temp.next = n;

            this.size++;
        }
    }
    // removefirst
    // removelast
    // removeat

    public int removeFirst() {

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {

        int val = tail.data;
        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
        return val;

    }

    public int removeAt(int index) {

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {

            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return val;

    }

    // getfirst
    public int getFirst() {
        if (size() == 0) {
            return -1;
        }

        return this.head.data;
    }

    // getlast
    public int getLast() {
        if (size() == 0) {
            return -1;
        }
        return this.tail.data;
    }

    // getAt
    public int getAt(int index) {

        if (index < 0 || index > this.size) {
            System.out.println("Invalid index");
            return -1;

        }
        Node temp = head;
        for (int i = 0; i < index; i++) {

            temp = temp.next;
        }
        System.out.println(temp.data);
        return temp.data;
    }

    public void displayList() {

        Node temp = head;
        while (temp != null) {

            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    public int size() {
        return this.size;
    }
}