#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> triangle) {
    int N = triangle.size();
    vector<vector<int>> dp(N + 1);
    for (int i = 1; i <= N; i++) dp[i].resize(i);
    dp[1][0] = triangle[0][0];
    for (int i = 2; i <= N; i++) {
        for (int j = 0; j < i; j++) {
            if (j == 0)
                dp[i][j] = triangle[i-1][j] + dp[i-1][j];
            else if (j == i -1)
                dp[i][j] = triangle[i-1][j] + dp[i-1][j-1];
            else
                dp[i][j] = triangle[i-1][j] + max(dp[i-1][j-1], dp[i-1][j]);
        }
    }
    return *max_element(dp[N].begin(), dp[N].end());
}