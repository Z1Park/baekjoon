#include <iostream>
#define max(a, b) ((a > b) ? a : b);
#define FIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

int main() {
	int n, m, sum = 0, res = 10000001;
	int memory[101];
	int cost[101];
	int dp[10001] = {0, };

	FIO;
	cin >> n >> m;
	for (int i = 0; i < n; i++) cin >> memory[i];
	for (int i = 0; i < n; i++) {
		cin >> cost[i];
		sum += cost[i];
		for (int j = sum; j >= 1; j--) {
			if (j >= cost[i]) dp[j] = max(dp[j], dp[j-cost[i]]+memory[i]);
			if (dp[j] >= m && res > j) res = j;
		}
	}
	cout << res;
}
