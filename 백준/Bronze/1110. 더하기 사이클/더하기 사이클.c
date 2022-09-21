#include <stdio.h>

int main() {
	int a, b=0;
	int cnt = 0;
	int sum = 0;

	scanf("%d", &a);
	sum = a;
	while (1) {
		cnt += 1;
		b = sum / 10 + sum % 10;
		sum = sum % 10 * 10 + b % 10;
		if (sum == a)
			break;
	}
	printf("%d\n", cnt);

	return 0;
}