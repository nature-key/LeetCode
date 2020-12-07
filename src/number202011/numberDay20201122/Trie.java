package number202011.numberDay20201122;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.child[c - 'a'] == null) {
                ws.child[c - 'a'] = new TrieNode(c);
            }
            ws = ws.child[c - 'a'];
        }
        ws.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.child[c - 'a'] == null) {
                return false;
            }
            ws = ws.child[c - 'a'];
        }
        return ws.isEnd;
    }


    public boolean startWith(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.child[c - 'a'] == null) {
                return false;
            }
            ws = ws.child[c - 'a'];
        }
        return true;
    }


    public static void main(String[] args) {
        Trie trie =new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startWith("app"));
        System.out.println(trie.search("app"));
        trie.insert("app");
        System.out.println(trie.startWith("app"));
    }


}
