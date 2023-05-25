#include <iostream>
#define max(a, b) ((a > b) ? a : b);
#define FIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

int main() {
	int n, m, cost, sum = 0, res = 10000001;
	int memory[101], dp[10001] = {0, };

	FIO;
	cin >> n >> m;
	for (int i = 0; i < n; i++) cin >> memory[i];
	for (int i = 0; i < n; i++) {
		cin >> cost;
		sum += cost;
		for (int j = sum; j >= cost; j--) {
			dp[j] = max(dp[j], dp[j-cost]+memory[i]);
			if (dp[j] >= m && res > j) res = j;
		}
	}
	cout << res;
}
