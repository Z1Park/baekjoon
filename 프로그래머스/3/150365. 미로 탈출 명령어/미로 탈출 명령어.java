class Solution {
    
    private void checkMove(StringBuilder sb, int n, int x, int y) {
        if (x < n) sb.append("du");
        else if (y > 1) sb.append("lr");
        else sb.append("rl");
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int rowMove = r - x, colMove = c - y;
        int remainMove = k - Math.abs(rowMove) - Math.abs(colMove);
        int downMove = 0, leftMove = 0;
        if (remainMove < 0 || remainMove % 2 != 0) return "impossible";
        remainMove /= 2;
        StringBuilder sb = new StringBuilder();
        while (rowMove > 0) {
            sb.append('d');
            rowMove--;
            x++;
        }
        while (remainMove > 0 && x < n) {
            sb.append('d');
            remainMove--;
            downMove++;
            x++;
        }
        while (colMove < 0) {
            sb.append('l'); 
            colMove++;
            y--;
        }
        while (remainMove > 0 && 1 < y) {
            sb.append('l');
            remainMove--;
            leftMove++;
            y--;
        }
        while (remainMove > 0) {
            sb.append("rl");
            remainMove--;
        }
        while (colMove > 0) {
            sb.append('r');
            colMove--;
            y++;
        }
        while (leftMove > 0) {
            sb.append('r');
            y++;
            leftMove--;
        }
        while (rowMove < 0) {
            sb.append('u'); 
            rowMove++;
            x--;
        }
        while (downMove > 0) {
            sb.append('u');
            x++;
            downMove--;
        }
        return sb.toString();
    }
}