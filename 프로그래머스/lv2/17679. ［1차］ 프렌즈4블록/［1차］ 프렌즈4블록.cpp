#include <bits/stdc++.h>

using namespace std;

int solution(int m, int n, vector<string> board) {
    int R = board.size(), C = board[0].size();
    int count = 0;
    while (true) {
        int tmp = count;
        bool check[R][C];
        memset(check, 0, sizeof(check));
        for (int i = 0; i < R - 1; i++) {
            for (int j = 0; j < C - 1; j++) {
                if (board[i][j] != ' '
                   && board[i][j] == board[i+1][j]
                   && board[i][j] == board[i][j+1]
                   && board[i][j] == board[i+1][j+1]) {
                    for (int k = 0; k < 4; k++) {
                        check[i][j] = true;
                        check[i+1][j] = true;
                        check[i][j+1] = true;
                        check[i+1][j+1] = true;
                    }
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (check[i][j]) {
                    count++;
                    board[i][j] = ' ';
                }
            }
        }
        if (tmp == count) break;
        for (int i = R - 1; i >= 0; i--) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == ' ') {
                    for (int idx = i - 1; idx >= 0; idx--) {
                        if (board[idx][j] != ' ') {
                            board[i][j] = board[idx][j];
                            board[idx][j] = ' ';
                            break;
                        }
                    }
                }
            }
        }
    }
    return count;
}