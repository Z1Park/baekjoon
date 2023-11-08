#include <bits/stdc++.h>

using namespace std;

int cnt;

bool checkPromise(vector<int>& board, int n, int r, int c) {
    for (int i = 1; i < r; i++) {
        if (board[i] == c) return false;
        if (board[i] == c + r - i) return false;
        if (board[i] == c - (r - i)) return false;
    }
    return true;
}

void dfs(vector<int>& board, int n, int r) {
    if (r == n) {
        cnt++;
        return;
    }
    
    for (int i = 1; i <= n; i++) {
        if (!checkPromise(board, n, r+1, i)) continue;
        board[r+1] = i;
        dfs(board, n, r+1);
        board[r+1] = 0;
    }
}

int solution(int n) {
    if (n == 1) return 1;
    vector<int> board(n+1);
    for (int i = 1; i <= n; i++) {
        board[1] = i;
        dfs(board, n, 1);
    }
    return cnt;
}