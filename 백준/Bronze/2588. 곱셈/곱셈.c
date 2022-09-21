#include <stdio.h>

int main() {
	int a, b;
	int b100, b10, b1;
	scanf("%d", &a);
	scanf("%d", &b);
	b100 = b / 100;
	b10 = (b%100) / 10;
	b1 = b % 10;

	printf("%d\n", a * b1);
	printf("%d\n", a * b10);
	printf("%d\n", a * b100);
	printf("%d\n", a * b);


	return 0;
}