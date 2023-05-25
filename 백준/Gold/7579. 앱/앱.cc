#include <stdio.h>
#define max(a, b) ((a > b) ? a : b);

int main() {
	int n, m, cost, sum = 0, res = 10000001;
	int memory[101], dp[10001] = {0, };

	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) scanf("%d", &memory[i]);
	for (int i = 0; i < n; i++) {
		scanf("%d", &cost);
		sum += cost;
		for (int j = sum; j >= cost; j--) {
			dp[j] = max(dp[j], dp[j-cost]+memory[i]);
			if (dp[j] >= m && res > j) res = j;
		}
	}
	printf("%d", res);
}
