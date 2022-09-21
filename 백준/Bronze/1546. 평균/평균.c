#include <stdio.h>
#include <stdlib.h>

int main() {
	int n;
	float a[1000];
	float max = 0;
	float sum = 0;

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d",&a[i]);
		if (a[i] > max)
			max = a[i];
	}

	for (int j = 0; j < n; j++) {
		a[j] = a[j] / max * 100;
		sum += a[j];
	}

	printf("%f", sum / n);

	return 0;
}