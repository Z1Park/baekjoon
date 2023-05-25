#include <stdio.h>
#include <algorithm>

using namespace std;

int main() {
	int n;
	long long solution[5001];
	scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%lld", &solution[i]);
	sort(solution, solution+n);
	long long minval = 3000000001;
	long long res[3] = {0, };
	for (int i = 0; i < n - 2; i++) {
		int start = i+1;
		int end = n-1;
		while (start < end) {
			long long sum = solution[i] + solution[start] + solution[end];
			if (minval > abs(sum)) {
				minval = abs(sum);
				res[0] = solution[i];
				res[1] = solution[start];
				res[2] = solution[end];
			}
			if (sum < 0) start++;
			else end--;
		}
	}
	printf("%lld %lld %lld", res[0], res[1], res[2]);
	return 0;
}
