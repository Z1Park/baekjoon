#include <iostream>
#include <algorithm>
#define FIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

int n, m;
int sum;
int memory[101];
int cost[101];
int dp[10000001];

void printDP() {
	cout << endl;
	for (int i = 1; i <= m; i++) {
		cout << dp[i] << " ";
	}
	cout << endl;
}

int main() {
	FIO;
	cin >> n >> m;
	for (int i = 0; i < n; i++)
		cin >> memory[i];
	for (int i = 0; i < n; i++) {
		cin >> cost[i];
		sum += cost[i];
	}
	for (int i = 0; i < n; i++) {
		for (int j = sum; j >= 1; j--) {
			if (j >= cost[i])
				dp[j] = max(dp[j], dp[j-cost[i]]+memory[i]);
		}
	}
	for (int i = 1; i <= sum; i++) {
		if (dp[i] >= m) {
			cout << i << endl;
			break;
		}
	}
}
