package 阶段一;

import java.util.*;

public class N皇后 {

    public List<List<String>> solveQueue(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        backtrack(solutions, queens, n, 0, columns, pie, na);
        return solutions;
    }


    private void backtrack(List<List<String>> solutions, int[] queens,
                           int n, int row, Set<Integer> col, Set<Integer> pie, Set<Integer> na) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (col.contains(i)) {
                    continue;
                }
                int pievalue = row - i;
                if (pie.contains(pievalue)) {
                    continue;
                }
                int naValue = row + i;
                if (na.contains(naValue)) {
                    continue;
                }
                queens[row] = i;
                col.add(i);
                pie.add(pievalue);
                na.add(naValue);
                backtrack(solutions, queens, n, row + 1, col, pie, na);
                queens[row] = -1;
                col.remove(i);
                pie.remove(pievalue);
                na.remove(naValue);
            }


        }


    }

    //这里就是组装每一种其情况

    /**
     * queues[i]的值 可以理解是第几个皇后在哪一行
     *
     * @param queues
     * @param n
     * @return
     */
    private List<String> generateBoard(int[] queues, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] rows = new char[n];
            Arrays.fill(rows, '.');
            rows[queues[i]] = 'Q';
            board.add(new String(rows));
        }
        return board;
    }

    public static void main(String[] args) {
        N皇后 n皇后 = new N皇后();
        System.out.println(n皇后.solveQueue(4));
    }


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queue = new int[n];
        Arrays.fill(queue, -1);

        Set<Integer> col = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();

        dfs(result, queue, n, 0, col, pie, na);
        return result;

    }

    private void dfs(List<List<String>> result, int[] queue, int n, int row, Set<Integer> col, Set<Integer> pie, Set<Integer> na) {
        if (row == n) {
            List<String> list = generateQueue(queue, n);
            result.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col.contains(i)) {
                continue;
            }
            int p = row + i;
            if (pie.contains(p)) {
                continue;
            }
            int ne = row - i;
            if (na.contains(ne)) {
                continue;
            }
            queue[row] = i;
            col.add(i);
            pie.add(p);
            na.add(ne);
            dfs(result, queue, n, row + 1, col, pie, na);
            queue[row] = -1;
            col.remove(i);
            pie.remove(p);
            na.remove(ne);


        }


    }

    private List<String> generateQueue(int[] queue, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queue[i]] = 'Q';
            board.add(row.toString());
        }
        return board;
    }


    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> result = new ArrayList<>();

        int[] queues = new int[n];

        Arrays.fill(queues, -1);

        Set<Integer> cols = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();

        dfs1(result, queues, cols, pie, na, 0, n);
        return result;
    }

    private void dfs1(List<List<String>> result, int[] queues, Set<Integer> cols,
                      Set<Integer> pie, Set<Integer> na, int row, int n) {
        if (row == n) {
            List<String> res = gen(queues, n);
            result.add(res);
            return;
        } else {
            for (int i = 0; i < n; i++) {
                if (cols.contains(i)) {
                    continue;
                }
                int p = row + i;
                if (pie.contains(p)) {
                    continue;
                }
                int ne = row - i;
                if (na.contains(ne)) {
                    continue;
                }
                queues[row] = i;
                cols.add(i);
                na.add(ne);
                pie.add(p);
                dfs1(result, queues, cols, pie, na,
                        row + 1, n);
                cols.remove(i);
                na.remove(ne);
                pie.remove(p);
            }


        }
    }

    private List<String> gen(int[] queues, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queues[i]] = 'Q';
            result.add(row.toString());
        }
        return result;
    }


}
