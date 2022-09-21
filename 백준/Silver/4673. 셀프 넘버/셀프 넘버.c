#include <stdio.h>
#include <stdlib.h>

void self_num(int cnt) {
	int a, b, c, d, e;
	int temp;

	for (int j = 1; j <= cnt; j++) {
		d = j / 1000;
		c = (j % 1000) / 100;
		b = (j % 100) / 10;
		a = j % 10;
		temp = j + a + b + c + d;

		if (cnt == temp)
			break;
		if (cnt == j)
			printf("%d\n", j);
	}
	return;
}

int main() {
	int n;
	int* arr;

	n = 10000;
	arr = (int*)malloc(sizeof(int) * n);

	for (int i = 1; i <= n; i++) {
		self_num(i);
	}
	
	return 0;
}