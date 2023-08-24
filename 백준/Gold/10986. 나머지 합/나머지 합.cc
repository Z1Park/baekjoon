#include <stdio.h>

using namespace std;

int mod[1005];

int main() {
	int n, m;
	scanf("%d %d", &n, &m);
	long long tmp, sum = 0;
	for (int i = 0; i < n; i++) {
		scanf("%lld", &tmp);
		sum = (sum + tmp) % m;
		mod[sum]++;
	}
	long long count = mod[0];
	// 0 - 0, 1 - 1, 2 - 2, ... -> 조합 계산 nC2
	for (int i = 0; i < m; i++)
		count += (long long)mod[i] * (long long)(mod[i] - 1) / 2;
	printf("%lld", count);
}