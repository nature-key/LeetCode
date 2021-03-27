package number202103.numberDay20210327;

public class Trie {

    private TrieNode root=new TrieNode();

    public Trie() {
    }

    public Trie(TrieNode root) {
        this.root = root;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }

        node.setEnd(true);

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = serachprefix(word);
        return node != null && node.isEnd();
    }

    public TrieNode serachprefix(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containKey(ch)) {
                node = node.get(ch);
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = serachprefix(prefix);
        return node != null;
    }
}
