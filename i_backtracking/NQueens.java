public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        boolean[] col = new boolean[n];
        boolean[] posDiag = new boolean[2 * n];
        boolean[] negDiag = new boolean[2 * n];

        backtrack(0, n, board, col, posDiag, negDiag, res);
        return res;
    }

    private void backtrack(int r, int n, char[][] board,
                           boolean[] col, boolean[] posDiag, boolean[] negDiag,
                           List<List<String>> res) {
        if (r == n) {
            List<String> curr = new ArrayList<>();
            for (char[] row : board) curr.add(new String(row));
            res.add(curr);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col[c] || posDiag[r + c] || negDiag[r - c + n]) continue;

        }
    }
}