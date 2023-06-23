#include <iostream>
#define FIO ios::sync_with_stdio(0), cin.tie(0);

using namespace std;

int board[501][501];
int dp[501][501];
int n, m;

int dr[4] = {0, 1, 0, -1};
int dc[4] = {1, 0, -1, 0};

int dfs(int r, int c) {
	if (r == n-1 && c == m-1) return 1;
	if (dp[r][c] == -1) {
		dp[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (0 <= nr && nr < n && 0 <= nc && nc < m) {
				if (board[r][c] > board[nr][nc])
					dp[r][c] += dfs(nr, nc);
			}
		}
	}
	return dp[r][c];
}

int main() {
	FIO;

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> board[i][j];
			dp[i][j] = -1;
		}
	}
	cout << dfs(0, 0);

	return 0;
}