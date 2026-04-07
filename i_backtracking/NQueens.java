public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');


        backtrack(0, n, board, col, posDiag, negDiag, res);
        return res;
    }
}