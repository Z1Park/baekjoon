#include <stdio.h>

int main() {
	int sum = 0;
	int cnt = 0;
	int temp;
	
	while (cnt < 5) {
		cnt += 1;
		scanf("%d", &temp);
		if (temp < 40)
			sum += 40;
		else
			sum += temp;
	}
	printf("%d", sum / 5);
	return 0;
}