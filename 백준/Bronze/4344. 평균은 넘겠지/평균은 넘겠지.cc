#include <stdio.h>
#include <stdlib.h>

int main() {
	int c;
	int n;
	int arr[1000];
	int sum;
	float cnt;

	scanf("%d", &c);

	for (int i = 0; i < c; i++) {
		scanf("%d", &n);
		sum = 0;
		cnt = 0;
		for (int j = 0; j < n; j++) {
			scanf("%d", &arr[j]);
			sum += arr[j];
		}
		for (int j = 0; j < n; j++) {
			if (arr[j] > sum / n)
				cnt += 1;
		}
		printf("%.3f%\n", cnt / n * 100);
		
	}

	return 0;
}