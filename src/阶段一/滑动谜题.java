package 阶段一;


import java.util.*;

public class 滑动谜题 {

    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    /**
     * https://leetcode.cn/problems/sliding-puzzle/solution/hua-dong-mi-ti-by-leetcode-solution-q8dn/
     * @param board
     * @return
     */
    public int slidingPuzzle(int[][] board) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        String initStr = sb.toString();
        if ("123450".equals(initStr)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(initStr);

        Set<String> seen = new HashSet<>();
        seen.add(initStr);

        int step = 0;

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                for (String nextStatus : get(status)) {
                    if (!seen.contains(nextStatus)) {
                        if (nextStatus.equals("123450")) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        return -1;

    }


    public List<String> get(String status) {
        List<String> res = new ArrayList<>();
        char[] chars = status.toCharArray();
        int x = status.indexOf('0');
        for (int y : neighbors[x]) {
            swap(chars, x, y);
            res.add(chars.toString());
            swap(chars, x, y);
        }
        return res;
    }


    public void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }


}
