class LinkListCreationDemo {

    public static void main(String[] args) {
        linkedlist l = new linkedlist();

        l.addFirst(20);
        l.addFirst(10);
        l.addLast(30);
        l.addLast(40);
        System.out.println(l.size());
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
    }

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

    // public int removeFirst(int val) {

    // }

    // public int removeLast(int val) {

    // }

    // public int removeAt(int val, int index) {

    // }

    // getfirst
    // getlast
    // getAt

    public void displayList() {

        Node temp = head;
        while (temp.next != null) {

            System.out.println(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public int size() {
        return this.size;
    }
}