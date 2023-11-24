import java.util.*;

class Solution {
    public int solution(String[] board) {
        int[] count = new int[2];
        int[] check = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') count[0]++;
                else if (board[i].charAt(j) == 'X') count[1]++;
            }
            if (board[i].charAt(0) != '.' 
                && board[i].charAt(0) == board[i].charAt(1)
                && board[i].charAt(0) == board[i].charAt(2)) {
                if (board[i].charAt(0) == 'O') check[0]++;
                else check[1]++;
            }
            if (board[0].charAt(i) != '.' 
                && board[0].charAt(i) == board[1].charAt(i)
                && board[1].charAt(i) == board[2].charAt(i)) {
                if (board[0].charAt(i) == 'O') check[0]++;
                else check[1]++;
            }
        }
        if (board[0].charAt(0) != '.' 
            && board[0].charAt(0) == board[1].charAt(1)
            && board[1].charAt(1) == board[2].charAt(2)) {
            if (board[0].charAt(0) == 'O') check[0]++;
            else check[1]++;
        }
        if (board[0].charAt(2) != '.' 
            && board[0].charAt(2) == board[1].charAt(1)
            && board[1].charAt(1) == board[2].charAt(0)) {
            if (board[1].charAt(1) == 'O') check[0]++;
            else check[1]++;
        }
        System.out.println(check[0] + " " + check[1]);
        if (count[0] < count[1]) return 0;
        if (Math.abs(count[0] - count[1]) > 1) return 0;
        if (check[0] != 0 && check[1] != 0) return 0;
        if (check[0] != 0 && count[0] == count[1]) return 0;
        if (check[1] != 0 && count[0] > count[1]) return 0;
        return 1;
    }
}