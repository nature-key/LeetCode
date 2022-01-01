package 阶段热身.number202103.numberDay20210328;

import 阶段热身.number202103.numberDay20210327.TrieNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    TrieNode root = new TrieNode();
    //    TrieNode root=new TrieNode();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Set<String> result = new HashSet<>();


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

    public List<String> findWords(char[][] board, String[] words) {


        //构建trie
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board, i, j, visited, new StringBuffer(), root);
            }
        }

        return new ArrayList<>(result);
    }


    private static void dfs(char[][] board, int i, int j, boolean[][] visited,
                            StringBuffer sb, TrieNode root) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return;
        }

        //相当于剪枝，看看是否存在这个字符
        char ch = board[i][j];
        if (!root.containKey(ch)) {
            return;
        }
        sb.append(ch);

        if (root.getLinks()[ch-'a'].isEnd()) {
            result.add(sb.toString());
        }
        visited[i][j] = true;
        root=root.getLinks()[ch-'a'];
        for (int k = 0; k < 4; k++) {
            dfs(board, i + dx[k], j + dy[k], visited, sb, root);
        }
        //清除状态
        sb.delete(0, sb.length() - 1);
        visited[i][j] = false;

    }


    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] word = {"oath", "pea", "eat", "rain"};
        Solution solution = new Solution();
        System.out.println(solution.findWords(board, word));


    }


}
