#include <iostream>
#define fio ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

using namespace std;

char board[10000][500];
int dr[3] = {-1, 0, 1};
int dc[3] = {1, 1, 1};
int R, C, count;

bool dfs(int r, int c) {
	board[r][c] = 'x';
	if (c == C-1) {
		::count++;
		return true;
	}
	for (int i = 0; i < 3; i++) {
		int nr = r + dr[i];
		int nc = c + dc[i];
		if (0 <= nr && nr < R && 0 <= nc && nc < C && board[nr][nc] == '.')
			if (dfs(nr, nc)) return true;
	}
	return false;
}

int main() {
	fio;

	cin >> R >> C;
	for (int i = 0; i < R; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < C; j++) board[i][j] = str[j];
	}
	for (int i = 0; i < R; i++)
		dfs(i, 0);
	cout << ::count;

	return 0;
}