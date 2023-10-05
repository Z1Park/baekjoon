#include <bits/stdc++.h>

using namespace std;

int dp[100001][4];

int solution(vector<vector<int>> land) {
    for (int i = 0; i < 4; i++) dp[0][i] = land[0][i];
    for (int i = 1; i < land.size(); i++) {
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                if (j == k) continue;
                dp[i][j] = max(dp[i][j], dp[i-1][k] + land[i][j]);
            }
        }
    }
    return *max_element(dp[land.size()-1], dp[land.size()-1]+4);
}