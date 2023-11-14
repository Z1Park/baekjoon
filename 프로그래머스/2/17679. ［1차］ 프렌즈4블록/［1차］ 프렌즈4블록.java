import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int res = 0;
        char[][] arr = Arrays.stream(board)
            .map(String::toCharArray)
            .toArray(char[][]::new);
        while (true) {
            boolean[][] check = new boolean[m][n];
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n-1; j++) {
                    if (arr[i][j] != ' ' &&
                        arr[i][j] == arr[i+1][j] && 
                        arr[i][j] == arr[i][j+1] && 
                        arr[i][j] == arr[i+1][j+1]) {
                        check[i][j] = true;
                        check[i+1][j] = true;
                        check[i][j+1] = true;
                        check[i+1][j+1] = true;
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        cnt++;
                        arr[i][j] = ' ';
                    }
                }
            }
            if (cnt == 0) break;
            res += cnt;
            for (int i = m - 2; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] != ' ' && arr[i+1][j] == ' ') {
                        int idx = i+1;
                        while (idx < m && arr[idx][j] == ' ') idx++;
                        idx--;
                        arr[idx][j] = arr[i][j];
                        arr[i][j] = ' ';
                    }
                }
            }
        }
        return res;
    }
}