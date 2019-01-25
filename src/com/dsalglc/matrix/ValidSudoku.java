package com.dsalglc.matrix;

public class ValidSudoku {
    // 36. valid sudoku
    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] sub = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1, k = i / 3 * 3 + j / 3;
                    if (row[i][num] != 0 || col[j][num] != 0 || sub[k][num] != 0) {
                        return false;
                    } else {
                        row[i][num] = 1;
                        col[j][num] = 1;
                        sub[k][num] = 1;
                    }
                }
            }
        }
        return true;
    }
}
