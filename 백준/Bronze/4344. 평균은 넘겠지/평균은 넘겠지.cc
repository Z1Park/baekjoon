#include <stdio.h>
#include <math.h>

int main() {
	int c;
	scanf("%d", &c);
	for (int i = 0; i < c; i++) {
		int n, sum = 0;
		scanf("%d", &n);
		int nums[n];
		for (int j = 0; j < n; j++) {
			scanf("%d", &nums[j]);
			sum += nums[j];
		}
		float avg = ((float)sum) / n;
		int cnt = 0;
		for (int j = 0; j < n; j++)
			if (nums[j] > avg) cnt++;
		printf("%.3f%%\n", round((float)cnt / (float)n * 100000) / 1000);
	}
}
