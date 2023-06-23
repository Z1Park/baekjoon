#include <iostream>
#define FIO ios::sync_with_stdio(0), cin.tie(0);

using namespace std;

int board[51][51];
int acc[51][51];

int main() {
	FIO;

	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++)
			cin >> board[i][j];
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++)
			acc[i][j] = acc[i-1][j] + acc[i][j-1] - acc[i-1][j-1] + board[i][j];
	}
	int cnt = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j < n; j++) {
			for (int a = i; a <= n; a++) {
				for (int b = j; b < n; b++) {
					int prefixA = acc[a][b] - acc[a][j-1] - acc[i-1][b] + acc[i-1][j-1];
					for (int k = a+1; k <= n; k++) {
						for (int l = b+1; l <= n; l++) {
							int prefixB = acc[k][l] - acc[k][b] - acc[a][l] + acc[a][b];
							if (prefixA == prefixB) cnt++;
						}
					}
					for (int k = i-1; k > 0; k--) {
						for (int l = b+1; l <= n; l++) {
							int prefixB = acc[i-1][l] - acc[i-1][b] - acc[k-1][l] + acc[k-1][b];
							if (prefixA == prefixB) cnt++;
						}
					}
				}
			}
		}
	}
	cout << cnt;

	return 0;
}
