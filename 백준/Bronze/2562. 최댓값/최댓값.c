#include <stdio.h>
#include <stdlib.h>

int main() {
	int N=9;
	int max = 0;
	int temp, cnt =0;


	for (int i = 1; i <= N; i++) {
		scanf("%d", &temp);
		if (max < temp) {
			max = temp;
			cnt = i;
		}
	}
	printf("%d\n%d", max,cnt);

	return 0;
}