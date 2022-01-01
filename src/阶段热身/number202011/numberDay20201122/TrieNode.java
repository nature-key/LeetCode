package 阶段热身.number202011.numberDay20201122;

public class TrieNode {

    public char val;

    public boolean isEnd;

    public TrieNode[] child = new TrieNode[26];

    public TrieNode() {
    }

    public TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }


    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public TrieNode[] getChild() {
        return child;
    }

    public void setChild(TrieNode[] child) {
        this.child = child;
    }
}
