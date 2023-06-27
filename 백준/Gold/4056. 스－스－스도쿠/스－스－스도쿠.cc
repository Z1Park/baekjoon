#include <iostream>
#include <string>
#define FIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

typedef pair<int, int> pii;

int board[9][9];
pii blank[5];

int checkPromising(int r, int c) {
	int checkRow = 0, checkCol = 0;
	for (int i = 0; i < 9; i++) {
		if (board[r][i] == 0 || board[i][c] == 0) return 0;
		if ((checkRow & (1 << board[r][i])) == 0)
			checkRow |= 1 << board[r][i];
		else return -1;
		if ((checkCol & (1 << board[i][c])) == 0)
			checkCol |= 1 << board[i][c];
		else return -1;
	}
	int check = 0;
	for (int i = 0; i < 3; i++) {
		int row = r - r % 3 + i;
		for (int j = 0; j < 3; j++) {
			int col = c - c % 3 + j;
			if (board[row][col] == 0) return 0;
			if ((check & (1 << board[row][col])) == 0)
				check |= 1 << board[row][col];
			else return -1;
		}
	}
	return 1;
}

void printBoard() {
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++)
			cout << board[i][j];
		cout << endl;
	}
}

bool dfs(int depth) {
	if (depth == 5) {
		for (int i = 0; i < 5; i++) {
			int r = blank[i].first, c = blank[i].second;
			if (checkPromising(r, c) != 1) return false;
		}
		printBoard();
		return true;
	}
	int r = blank[depth].first, c = blank[depth].second;
	for (int i = 1; i < 10; i++) {
		board[r][c] = i;
		int res = checkPromising(r, c);
		if (res != -1) {
			if (dfs(depth + 1)) return true;
		}
		board[r][c] = 0;
	}
	return false;
}

int main() {
	FIO;

	int tc;
	cin >> tc;
	while (tc--) {
		int idx = 0;
		for (int i = 0; i < 9; i++) {
			string line;
			cin >> line;
			for (int j = 0; j < 9; j++) {
				board[i][j] = line[j] - '0';
				if (board[i][j] == 0)
					blank[idx++] = make_pair(i, j);
			}
		}
		if (!dfs(0)) cout << "Could not complete this grid.\n";
		if (tc != 0) cout << endl;
	}

	return 0;
}
