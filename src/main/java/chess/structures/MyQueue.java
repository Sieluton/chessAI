package chess.structures;

public class MyQueue {
    public Node first;
    public Node last;
    public int queuesize = 0;

    /**
     * Adds object to the end of the queue
     * @param object Object to be added to queue
     */
    public void add(Object object) {
        Node node = new Node(object);
        if (this.isEmpty()) {
            this.first = node;
        }
        else {
            this.last.setNext(node);
        }
        this.last = node;
        this.queuesize++;
    }

    /**
     * Returns object from the start of the linked list and removes it from the list
     * @return
     */
    public Object pop() {
        Object object = this.first.getObject();
        this.first = this.first.next;
        this.queuesize--;
        return object;
    }

    /**
     * Checks is the queue empty
     * @return True if queue is empty
     */
    public boolean isEmpty() {
        return (queuesize == 0);
    }

    /**
     * Makes copy of this queue
     * @return copy of the queue
     */
    public MyQueue clone() {
        MyQueue copyqueue = new MyQueue();
        if (this.isEmpty()) {
            return copyqueue;
        }
        Node node = this.first;
        copyqueue.add(node.getObject());
        for (int i = 2; i <= this.queuesize; i++) {
            node = node.next;
            copyqueue.add(node.getObject());
        }
        return copyqueue;
    }

    /**
     * Returns size of the queue
     * @return int of the size of queue
     */
    public int size() {
        return this.queuesize;
    }

    /**
     * Node in linked list
     */
    public class Node {
        public Object object;
        public Node next;

        /**
         * Constructor for Node in linked list
         * @param object Object that you want in the node
         */
        public Node(Object object) {
            this.object = object;
        }

        /**
         * Get current nodes object
         * @return Object of the node
         */
        public Object getObject() {
            return this.object;
        }

        /**
         * Sets reference to next node in linked list
         * @param node Next node in linked list
         */
        public void setNext(Node node) {
            this.next = node;
        }
    }
}
