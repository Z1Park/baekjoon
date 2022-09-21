#include <stdio.h>
#include <stdlib.h>

int main() {
	int N;
	scanf("%d", &N);

	for (int b = 1; b < 2*N; b= b+2)
	{
		for (int a = 1; a <= (N + 1) / 2; a++) {
			printf("* ");
		}
		printf("\n");
		for (int a = 1; a <= N / 2; a++) {
			printf(" *");
		}
		printf("\n");
	}

	return 0;
}