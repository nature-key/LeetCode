package 阶段一;

public class Trie {

    private TrieNode root;

    public  Trie(){
        root=new TrieNode();
    }

    public void insert(String word){
        TrieNode current=root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index=c-'a';
            if(current.children[index]==null){
                current.children[index]=new TrieNode();
                current.children[index].isWord=false;
            }
            current=current.children[index];
        }
        current.isWord=true;
    }

    public boolean search(String word){
        TrieNode curent=find(word);
        return curent!=null&&curent.isWord;

    }

    public boolean startWith(String prefix){
        return find(prefix)!=null;

    }
    private TrieNode find(String str){
        TrieNode current=root;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            int index=str.charAt(i)-'a';
             current = current.children[index];
             if(current==null){
                 return null;
             }
        }
        return current;
    }



}

class TrieNode{

    boolean isWord;
    TrieNode[] children;

    public TrieNode() {
        this.isWord = true;
        this.children = new TrieNode[26];
    }
}
