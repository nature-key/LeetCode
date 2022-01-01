package 阶段热身.number202012.numberDay20201202;

import 阶段热身.number202011.numberDay20201122.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    private static Set<String> res = new HashSet<>();

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board,words));

    }

    public static List<String> findWords(char[][] board, String[] words) {
        //1.把字段放入trie中
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        //2.深度遍历每一个字符
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }
        return new ArrayList<>(res);
    }

    private static void dfs(char[][] board, boolean[][] visited, String s, int x, int y, Trie trie) {
        //3判断是否越界
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        //4.访问过的不在继续下面
        if (visited[x][y]) {
            return;
        }
        //5.组一个新的单词
        s += board[x][y];
        //6.判断这个单词是否在trie中的前缀，
        if (!trie.startWith(s)) {
            return;
        }
        //7.判断这个单词是否在trie
        if (trie.search(s)) {
            res.add(s);
        }
        //8.移动上下左右，判断是否有字段存在
        visited[x][y] = true; //这个字符用过
        dfs(board, visited, s, x - 1, y, trie);
        dfs(board, visited, s, x + 1, y, trie);
        dfs(board, visited, s, x, y - 1, trie);
        dfs(board, visited, s, x, y + 1, trie);
        visited[x][y] = false;//恢复

    }


}
