#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
#define FIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

bool rangeCheck(int r, int c, int n) {
	if (0 <= r && r < n && 0 <= c && c < n)
		return true;
	return false;
}

int main() {
	FIO;

	int pr[8] = {-1, -1, -1, 0, 1, 1, 1, 0};
	int pc[8] = {-1, 0, 1, 1, 1, 0, -1, -1};
	int qr[8] = {-1, 0, 1, 1, 1, 0, -1, -1};
	int qc[8] = {1, 1, 1, 0, -1, -1, -1, 0};
	int rr[4] = {-1, 0, 1, 0};
	int rc[4] = {0, 1, 0, -1};
	int br[4] = {-1, -1, 1, 1};
	int bc[4] = {-1, 1, -1, 1};
	int kr[8] = {2, 1, -1, -2, -2, -1, 1, 2};
	int kc[8] = {1, 2, 2, 1, -1, -2, -2, -1};

	int n;
	cin >> n;
	char board[n][n];
	int start, end;
	vector<pair<int, int>> nodes;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> board[i][j];
			if (board[i][j] != '0') {
				if (board[i][j] == 'P') start = nodes.size();
				else if (board[i][j] == 'K') end = nodes.size();
				nodes.push_back(make_pair(i, j));
			}
		}
	}

	int res[n][n];
	memset(res, -1, sizeof(res));
	priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<> > pq;
	pq.push({0, make_pair(nodes[start].first, nodes[start].second)});
	res[nodes[start].first][nodes[start].second] = 0;
	while (!pq.empty()) {
		int dist = pq.top().first;
		int r = pq.top().second.first, c = pq.top().second.second;
		pq.pop();
		switch (board[r][c]) {
			case 'P':
				for (int i = 0; i < 8; i++) {
					int dr = r + pr[i];
					int dc = c + pc[i];
					if (rangeCheck(dr, dc, n) && board[dr][dc] != '0') {
						int weight = dist + 1;
						if (res[dr][dc] == -1 || weight < res[dr][dc]) {
							pq.push({weight, make_pair(dr, dc)});
							res[dr][dc] = weight;
						}
					}
				}
				break;
			case 'Q':
				for (int i = 0; i < 8; i++) {
					for (int j = 1; j < n; j++) {
						int dr = r + qr[i] * j;
						int dc = c + qc[i] * j;
						if (rangeCheck(dr, dc, n)) {
							if (board[dr][dc] != '0') {
								int weight = dist + j;
								if (res[dr][dc] == -1 || weight < res[dr][dc]) {
									pq.push({weight, make_pair(dr, dc)});
									res[dr][dc] = weight;
								}
								if (board[dr][dc] != 'P')
									break;
							}
						}
						else break;
					}
				}
				break;
			case 'B':
				for (int i = 0; i < 4; i++) {
					for (int j = 1; j < n; j++) {
						int dr = r + br[i] * j;
						int dc = c + bc[i] * j;
						if (rangeCheck(dr, dc, n)) {
							if (board[dr][dc] != '0') {
								int weight = dist + j;
								if (res[dr][dc] == -1 || weight < res[dr][dc]) {
									pq.push({weight, make_pair(dr, dc)});
									res[dr][dc] = weight;
								}
								if (board[dr][dc] != 'P')
									break;
							}
						}
						else break;
					}
				}
				break;
			case 'R':
				for (int i = 0; i < 4; i++) {
					for (int j = 1; j < n; j++) {
						int dr = r + rr[i] * j;
						int dc = c + rc[i] * j;
						if (rangeCheck(dr, dc, n)) {
							if (board[dr][dc] != '0') {
								int weight = dist + j;
								if (res[dr][dc] == -1 || weight < res[dr][dc]) {
									pq.push({weight, make_pair(dr, dc)});
									res[dr][dc] = weight;
								}
								if (board[dr][dc] != 'P')
									break;
							}
						}
						else break;
					}
				}
				break;
			case 'N':
				for (int j = 0; j < 8; j++) {
					int dr = r + kr[j];
					int dc = c + kc[j];
					if (rangeCheck(dr, dc, n) && board[dr][dc] != '0') {
						int weight = dist + 2;
						if (res[dr][dc] == -1 || weight < res[dr][dc]) {
							pq.push({weight, make_pair(dr, dc)});
							res[dr][dc] = weight;
						}
					}
				}
				break;
			default:
				break;
		}
	}
	cout << res[nodes[end].first][nodes[end].second];

	return 0;
}
