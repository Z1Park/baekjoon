#include <stdio.h>
#include <stdlib.h>

int self_num(int num, int cnt) {
	int a, b, c;
	int temp;

	if (num == 1000)
		return cnt;

	c = (num % 1000) / 100;
	b = (num % 100) / 10;
	a = num % 10;

	if (c == 0)
		cnt += 1;

	else if ((a - b) == (b - c))
		cnt += 1;

	return cnt;
}

int main() {
	int n, cnt = 0;
	int* arr;

	scanf("%d", &n);
	arr = (int*)malloc(sizeof(int) * n);

	for (int i = 1; i <= n; i++) {
		cnt = self_num(i, cnt);
	}
	printf("%d", cnt);
	
	return 0;
}