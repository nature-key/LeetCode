package number202010.numberDay20201006;

public class LinkNode {

    int value;

    LinkNode next;

    public LinkNode() {
    }

    public LinkNode(int value) {
        this.value = value;
    }

    public LinkNode(int value, LinkNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
