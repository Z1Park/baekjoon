#include <stdio.h>
#include <algorithm>

using namespace std;

int dp[100001][5][5];

int calForce(int curr, int next) {
	if (curr == 0) {
		if (next == 0) return 1;
		return 2;
	}
	if (curr == next) return 1;
	if (curr + 2 == next || curr - 2 == next) return 4;
	return 3;
}

int main() {
	int i = 1;
	for (int j = 0; j < 5; j++) {
		for (int k = 0; k < 5; k++) dp[0][j][k] = 4000000;
	}
	dp[0][0][0] = 0;
	while (true) {
		int n;
		scanf("%d", &n);
		if (n == 0) break;
		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 5; k++)
				dp[i][j][k] = 4000000;
		}
		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 5; k++) {
				if (dp[i-1][j][k] >= 4000000) continue;
				int force1 = calForce(k, n);
				int force2 = calForce(j, n);
				dp[i][j][n] = min(dp[i][j][n], dp[i-1][j][k] + force1);
				dp[i][n][k] = min(dp[i][n][k], dp[i-1][j][k] + force2);
			}
		}
		i++;
	}
	i--;
	int minValue = 4000000;
	for (int j = 0; j < 5; j++) {
		for (int k = 0; k < 5; k++)
			if (minValue > dp[i][j][k]) minValue = dp[i][j][k];
	}
	printf("%d", minValue);
}