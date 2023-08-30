#include <stdio.h>

using namespace std;

bool nums[1000001];

int main() {
	long long MIN, MAX, tmp1, tmp2;
	scanf("%lld %lld", &MIN, &MAX);
	for (long long i = 2; ; i++) {
		tmp1 = i*i;
		if (tmp1 > MAX) break;
		for (long long j = MIN / tmp1; ; j++) {
			tmp2 = tmp1 * j;
			if (j == 0 || tmp2 < MIN) continue;
			if (tmp2 > MAX) break;
			nums[tmp2 - MIN] = true;
		}
	}
	long long count = 0, limit = MAX - MIN;
	for (int i = 0; i <= limit; i++)
		if (!nums[i]) count++;
	printf("%lld", count);

	return 0;
}