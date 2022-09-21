#include <stdio.h>
#include <stdlib.h>

int main() {
	int n;
	char arr[80];
	int sum, cnt;

	scanf("%d", &n);

	for (int 
		i = 0; i < n; i++) {
		scanf("%s", arr);
		sum = 0;
		cnt = 0;
		for (int j = 0; j < 80; j++) {
			if (arr[j] == 'O') {
				cnt += 1;
				sum += cnt;
			}
			else {
				cnt = 0;
			}
			if (arr[j] == NULL)
				break;
		}
		printf("%d\n", sum);
	}

	return 0;
}