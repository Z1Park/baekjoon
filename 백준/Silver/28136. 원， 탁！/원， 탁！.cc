#include <stdio.h>

using namespace std;

int main() {
	int n, cnt = 0, start, prev, tmp;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &tmp);
		if (i == 0) start = tmp;
		else if (tmp <= prev) cnt++;
		prev = tmp;
	}
	if (start <= tmp) cnt++;
	printf("%d", cnt);
	return 0;
}
