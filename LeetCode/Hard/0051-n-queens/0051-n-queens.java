class Solution {
    
    private int[] board;
    private List<List<String>> result = new ArrayList<>();
    
    
    private boolean isPossible(int r) {
        for (int i = 0; i < r; i++) {
            if (board[i] == board[r]) return false;
            if (board[i] == board[r] - (r - i)) return false;
            if (board[i] == board[r] + (r - i)) return false;
        }
        return true;
    }
    
    private List<String> makeList(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++)
            sb.append(".");
        String base = sb.toString();
        List<String> curr = new ArrayList<>();
        
        for (int c : board) {
            sb = new StringBuilder(base);
            sb.insert(c, "Q");
            curr.add(sb.toString());
        }
        return curr;
    }
    
    private void makeNQueen(int n, int r) {
        if (r >= n) {
            result.add(makeList(n));
            return;
        }
        
        for (int c = 0; c < n; c++) {
            board[r] = c;
            if (isPossible(r)) 
                makeNQueen(n, r+1);
        }
        board[r] = -1;
    }
    
    public List<List<String>> solveNQueens(int n) {
        board = new int[n];
        Arrays.fill(board, -1);
        makeNQueen(n, 0);
        return result;
    }
}