#include <iostream>
#include <string>
#include <algorithm>
#include <queue>
#include <cstring>
#define FIO ios::sync_with_stdio(0), cin.tie(0);

using namespace std;

int main() {
	FIO;

	int dr[4] = {1, 0, -1, 0};
	int dc[4] = {0, 1, 0, -1};

	int n, m;
	cin >> m >> n;
	int board[n][m];
	for (int i = 0; i < n; i++) {
		string tmp;
		cin >> tmp;
		for (int j = 0; j < m; j++)
			board[i][j] = tmp[j] - '0';
	}
	int res[n][m];
	memset(res, -1, sizeof(res));
	priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<>> pq;
	pq.push({0, make_pair(0, 0)});
	res[0][0] = 0;
	while (!pq.empty()) {
		int dist = pq.top().first;
		int r = pq.top().second.first, c = pq.top().second.second;
		pq.pop();
		if (r == n-1 && c == m-1) break;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (0 <= nr && nr < n && 0 <= nc && nc < m) {
				int weight = dist + board[nr][nc];
				if (res[nr][nc] == -1 || res[nr][nc] > weight) {
					res[nr][nc] = weight;
					pq.push({weight, make_pair(nr, nc)});
				}
			}
		}
	}
	cout << res[n-1][m-1];
}
