#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>
#include <deque>

using namespace std;

typedef struct {
	int r;
	int c;
	int cnt;
	int flag;
} t_que;

char board[1000][1000];
bool visit[1000][1000][2];
int dr[4] = {1, -1, 0, 0};
int dc[4] = {0, 0, -1, 1};

int main() {
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> board[i][j];
			visit[i][j][0] = false;
			visit[i][j][1] = false;
		}
	}

	int res = 1000001;
	deque<t_que> dq;
	dq.push_back({0, 0, 1, 0});
	while (!dq.empty()) {
		t_que tmp = dq.front();
		dq.pop_front();
		if (tmp.r == n-1 && tmp.c == m-1) {
			res = min(res, tmp.cnt);
		}
		for (int i = 0; i < 4; i++) {
			int sr = tmp.r + dr[i];
			int sc = tmp.c + dc[i];
			if (0 <= sr && sr < n && 0 <= sc && sc < m) {
				if (board[sr][sc] == '0' && !visit[sr][sc][tmp.flag]) {
					visit[sr][sc][tmp.flag] = true;
					dq.push_back({sr, sc, tmp.cnt+1, tmp.flag});
				}
				else if (tmp.flag == 0 && !visit[sr][sc][1]) {
					dq.push_back({sr, sc, tmp.cnt+1, 1});
				}
			}
		}
	}
	cout << ((res == 1000001) ? -1 : res);
}
