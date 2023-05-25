#include <stdio.h>

int n, m;
int lec[100001];

int promise(int size) {
	int tmp = 0, i = 0;
	for (int j = 0; j < n; j++) {
		if (tmp + lec[j] > size) {
			i++;
			tmp = 0;
		}
		tmp += lec[j];
	}
	if (tmp != 0) i++;
	if (i <= m) return false;
	return true;
}

int binSearch(int start, int end) {
	while (start <= end) {
		int mid = (start + end) / 2;
		if (promise(mid)) start =  mid + 1;
		else end = mid - 1;
	}
	return start;
}

int main() {
	int minsize = 0, maxsize = 0;
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%d", &lec[i]);
		maxsize += lec[i];
		if (minsize < lec[i]) minsize = lec[i];
	}
	int res = binSearch(minsize, maxsize);
	printf("%d", res);
}
