#include <bits/stdc++.h>

using namespace std;

int solution(vector<vector<int>> board) {
    int R = board.size(), C = board[0].size();
    int maxValue = -1;
    vector<vector<int>> dp(R);
    for (int i = 0; i < dp.size(); i++)
        dp[i].resize(C);
    for (int i = R-1; i >= 0; i--) {
        for (int j = C-1; j >=0; j--) {
            if (i == R-1 || j == C-1) dp[i][j] = board[i][j];
            else {
                if (board[i][j] == 1)
                    dp[i][j] = min(min(dp[i][j+1], dp[i+1][j]), dp[i+1][j+1])+1;
                else
                    dp[i][j] = 0;
                if (maxValue < dp[i][j]) maxValue = dp[i][j];
            }
        }
    }
    return maxValue * maxValue;
}