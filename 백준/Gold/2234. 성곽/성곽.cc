#include <iostream>
#include <deque>
#include <vector>
#define fio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

typedef pair<int, int> pii;

int n, m;
int board[50][50];
int visited[50][50];
int dr[4] = {0, -1, 0, 1};
int dc[4] = {-1, 0, 1, 0};

int curr;
vector<int> area;


void bfs(int start_r, int start_c, int idx) {
	deque<pii> dq;
	dq.push_back(make_pair(start_r, start_c));
	curr = 1;
	while (!dq.empty()) {
		int r = dq.front().first, c = dq.front().second;
		if (curr > area[idx]) area[idx] = curr;
		dq.pop_front();

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (0 <= nr && nr < n && 0 <= nc && nc < m) {
				if ((board[r][c] & (1 << i)) == 0 && visited[nr][nc] == 0) {
					visited[nr][nc] = idx;
					curr++;
					dq.push_back(make_pair(nr, nc));
				}
			}
		}
	}
}

int main() {
	fio;

	cin >> m >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) cin >> board[i][j];
	}
	area.push_back(-1);
	int idx = 1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (visited[i][j] == 0) {
				visited[i][j] = idx;
				area.push_back(0);
				bfs(i, j, idx);
				idx++;
			}
		}
	}

	cout << (idx - 1) << endl;
	int maxArea = 0;
	for (int i = 0; i < area.size(); i++) {
		if (maxArea < area[i]) maxArea = area[i];
	}
	cout << maxArea << endl;
	maxArea = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			for (int k = 0; k < 4; k++) {
				int r = i + dr[k];
				int c = j + dc[k];
				if (0 <= r && r < n && 0 <= c && c < m) {
					if (visited[i][j] != visited[r][c]) {
						int tmp = area[visited[i][j]] + area[visited[r][c]];
						if (maxArea < tmp) maxArea = tmp;
					}
				}
			}
		}
	}
	cout << maxArea << endl;

	return 0;
}