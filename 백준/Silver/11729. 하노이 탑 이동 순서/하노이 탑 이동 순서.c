#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

void function(int n, int from, int temp, int to) {

	if (n == 1) {
		printf("%d %d\n",from, to);
	}
	else {
		function(n-1,from, to, temp);
		printf("%d %d\n", from, to);
		function(n-1, temp, from, to);
	}
}

int main() {
	int n;
	int a = 1, b = 2, c = 3;

	int res;
	
	scanf("%d", &n);

	res = pow(2, n) - 1;

	printf("%d\n", res);

	function(n, a, b, c);

	return 0;
}