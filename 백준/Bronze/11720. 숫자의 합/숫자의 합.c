#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	int n;
	int sum = 0;
	char* str;

	scanf("%d", &n);	
	
	str = (char*)malloc(sizeof(char) * n);

	for (int i = 0; i <= n; i++) {
		scanf("%c", &str[i]);
		sum += atoi(&str[i]);
	}

	printf("%d", sum);

	return 0;
}