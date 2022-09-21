#include <stdio.h>
#include <stdlib.h>

int main() {
	char n;

	scanf("%c", &n);

	if ((n > 9) || (n < 0))
		printf("%d\n", n);
	else
		printf("%d\n", n+48);

	
	return 0;
}