#include <stdio.h>

using namespace std;

long long n, k;

bool promise(long long value) {
	long long count = 0, tmp;
	for (long long i = 1; i <= n; i++) {
		tmp = value / i;
		count += (tmp > n) ? n : tmp;
		if (count >= k) return true;
	}
	return false;
}

int main() {

	scanf("%lld\n%lld", &n, &k);
	long long start = 1, end = n * n, mid;
	while (start <= end) {
		mid = (start + end) / 2;
		if (promise(mid)) end = mid - 1;
		else start = mid + 1;
	}
	printf("%lld", start);

	return 0;
}