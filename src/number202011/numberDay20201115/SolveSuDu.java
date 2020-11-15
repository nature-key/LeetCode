package number202011.numberDay20201115;

public class SolveSuDu {

    public static void main(String[] args) {
        char[][] board = new char[9][9];

        if (board == null || board.length == 0) {
            System.out.println("格式不正确");
        } else {
            solve(board);
        }
        System.out.println(board.toString());

    }

    public static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c < '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i< 9; i++) {
            if (board[i][col]!='.' && board[i][col]==c) {
                return false;
            }
            if (board[row][i]!='.'&&board[row][i]==c) {
                return false;
            }
            if (board[3*(row/3)+i/3][3*(col/3)+i%3]!='.'&&
                    board[3*(row/3)+i/3][3*(col/3)+i%3]=='c') {
                return false;
            }
        }
        return true;
    }

}
