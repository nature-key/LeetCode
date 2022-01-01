package 阶段热身.number202103.numberDay20210327;

public class TrieNode {


    private TrieNode[] links;

    private int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }


    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }


    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public TrieNode[] getLinks() {
        return links;
    }

    public void setLinks(TrieNode[] links) {
        this.links = links;
    }
}
