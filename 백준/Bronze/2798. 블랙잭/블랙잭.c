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
	int n, m;
	int diff = 300000;
	int nlst[100] = { NULL };
	int sum;

	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) {
		scanf("%d",&nlst[i]);
	}

	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			for (int k = j + 1; k < n; k++) {
				sum = nlst[i] + nlst[j] + nlst[k];
				if ((m >= sum)&&(diff > m - sum))
					diff = m - sum;
			}
		}
	}

	printf("%d", m - diff);

	return 0;
}