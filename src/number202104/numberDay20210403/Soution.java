package number202104.numberDay20210403;

public class Soution {


    public static boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValied(board, i, j, c)) {
                            board[i][j] = c;
                            if (isValidSudoku(board)) {
                                return true;
                            }
                                board[i][j] = '.';

                        }
                    }
                    return false;
                }
            }
        }

        return true;


    }

    private static boolean isValied(char[][] board, int row, int col, char c) {

        for (int k = 0; k < 9; k++) {
            if (board[k][col]!='.' && board[k][col] == c) {
                return false;
            }
            if (board[row][k]!='.' && board[row][k] == c) {
                return false;
            }
            if (board[3 * (row / 3) + k /3][3 * (col / 3) + k %3] != '.' &&
                    board[3 * (row / 3) + k / 3][3 * (col / 3) + k % 3] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] c = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {
                        '7', '.', '.', '.', '2', '.', '.', '.', '6'
                },
                {
                        '.', '6', '.', '.', '.', '.', '2', '8', '.'
                },
                {
                        '.', '.', '.', '4', '1', '9', '.', '.', '5'
                },
                {
                        '.', '.', '.', '.', '8', '.', '.', '7', '9'
                }
        };


        System.out.println(isValidSudoku(c));


    }


}
