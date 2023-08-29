#include <stdio.h>

using namespace std;

long long n, k;

bool promise(long long value) {
	long long count = 0;
	for (long long i = 1; i <= n; i++) {
		count += (value / i > n) ? n : value / i;
		if (count >= k) return true;
	}
	return false;
}

int main() {

	scanf("%lld\n%lld", &n, &k);
	long long start = 1, end = n * n;
	while (start <= end) {
		long long mid = (start + end) / 2;
		if (promise(mid)) end = mid - 1;
		else start = mid + 1;
	}
	printf("%lld", start);

	return 0;
}