#include <stdio.h>
#include <stdlib.h>

int main() {
	int N;
	int min = 1000000, max = -1000000;
	int temp;

	scanf("%d", &N);

	for (int i = 1; i <= N; i++) {
		scanf("%d", &temp);
		if (min > temp)
			min = temp;
		if (max < temp)
			max = temp;
	}
	printf("%d %d", min, max);

	return 0;
}