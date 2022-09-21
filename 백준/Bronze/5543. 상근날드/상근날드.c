#include <stdio.h>

int main() {
	int ham = 2000, bav = 2000;
	int cnt = 0;
	int temp;
	
	while (cnt < 3) {
		scanf("%d", &temp);
		if (ham > temp)
			ham = temp;
		cnt += 1;
	}
	cnt = 0;
	while (cnt < 2) {
		scanf("%d", &temp);
		if (bav > temp)
			bav = temp;
		cnt += 1;
	}
	printf("%d", ham + bav -50);
	return 0;
}