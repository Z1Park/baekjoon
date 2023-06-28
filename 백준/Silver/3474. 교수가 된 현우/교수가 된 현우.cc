#include <stdio.h>

using namespace std;

int main() {
	int tc;
	scanf("%d", &tc);
	while (tc--) {
		int n;
		scanf("%d", &n);
		int cnt = 0;
		for (int i = 5; i <= n; i *= 5) cnt += n / i;
		printf("%d\n", cnt);
	}
}