#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n, m;
vector<int> pnum;
int dp[5001];

int main() {
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		int s = 0;
		int tmp = i;
		while (tmp) {
			s += tmp % 10;
			tmp /= 10;
		}
		if (i % s == 0) pnum.push_back(i);
	}
	for (int i = 0; i <= n; i++)
		dp[0] = 1;
	for (int i = 1; i <= pnum.size(); i++) {
		for (int j = 1; j <= n; j++) {
			if (j >= pnum[i-1])
				dp[j] = (dp[j] + dp[j-pnum[i-1]]) % m;
		}
	}
	cout << dp[n] << endl;
}
