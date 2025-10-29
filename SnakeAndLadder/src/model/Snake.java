package model;

public class Snake {
    private int head;
    private int tail;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    void setHead(int head) {
        this.head = head;
    }

    void setTail(int tail) {
        this.tail = tail;
    }
}
