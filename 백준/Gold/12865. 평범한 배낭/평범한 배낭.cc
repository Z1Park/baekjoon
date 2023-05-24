#include <iostream>
#include <algorithm>

using namespace std;

int n, k;
int weight[101];
int value[101];
int dp[100001];

int main() {
	cin >> n >> k;
	for (int i = 1; i <= n; i++)
		cin >> weight[i] >> value[i];
	for (int i = 1; i <= n; i++) {
		for (int j = k; j >= 1; j--) {
			if (j >= weight[i])
				dp[j] = max(dp[j], dp[j-weight[i]] + value[i]);
		}
	}
	cout << dp[k];
}
