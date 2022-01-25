package 阶段一;

import java.util.*;

public class 单词搜索2 {


    Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        Boolean[][] visieed = new Boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Dfs(board, "", i, j, trie, visieed);
            }
        }
        return new ArrayList<>(res);
    }

    private void Dfs(char[][] board, String str,
                     int i, int j, Trie trie, Boolean[][] visisted) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if(visisted[i][j]){
            return;
        }
        str += board[i][j];
        if (!trie.startWith(str)) {
            return;
        }
        if (trie.search(str)) {
            res.add(str);
        }
        visisted[i][j] = true;
        Dfs(board, str, i - 1, j, trie, visisted);
        Dfs(board, str, i + 1, j, trie, visisted);
        Dfs(board, str, i, j - 1, trie, visisted);
        Dfs(board, str, i, j + 1, trie, visisted);
        visisted[i][j] = false;
    }

}
