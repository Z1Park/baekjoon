#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int calcnt(int weight) {
	int n=1;
	int cnt = weight/5;

	while (n != 0) {
		if (cnt < 0)
			return -1;
		n = (weight - 5 * cnt) % 3;
		cnt--;
	}
	
	return cnt+ (weight - 5 * cnt)/3;
}

int main() {
	int weight;

	scanf("%d", &weight);

	printf("%d", calcnt(weight));

	return 0;
}