#include <iostream>
#define FIO ios::sync_with_stdio(0), cin.tie(0);

using namespace std;

int board[51][51];
bool clear[51][51];
int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};

int main() {
	FIO;

	int n, m, r, c, d;
	cin >> n >> m;
	cin >> r >> c >> d;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) cin >> board[i][j];
	}

	int cnt = 0;
	while (true) {
		if (clear[r][c] == false) {
			cnt++;
			clear[r][c] = true;
		}
		bool flag = false;
		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4;
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (board[nr][nc] == 0 && clear[nr][nc] == false) {
				r = nr;
				c = nc;
				flag = true;
				break;
			}
		}
		// for (int i = 0; i < n; i++) {
		// 	for (int j = 0; j < m; j++) cout << clear[i][j] << " ";
		// 	cout << endl;
		// }
		// cout << endl;
		if (flag) continue;
		if (board[r - dr[d]][c - dc[d]] == 1) break;
		r -= dr[d];
		c -= dc[d];
	}
	cout << cnt << endl;

	return 0;
}
