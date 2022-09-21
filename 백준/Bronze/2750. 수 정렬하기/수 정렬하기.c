#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

void func1(int* arr, int n) {
	int temp;
	for (int j = n-2; j >= 0; j--) {
		for (int i = 0; i <= j; i++) {
			if (arr[i] > arr[i+1]) {
				temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
	}
}

int main() {
	int n;
	int cnt = 0;
	int* arr;

	scanf("%d", &n);

	arr = (int*)malloc(sizeof(int)*n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}

	func1(arr, n);

	for (int i = 0; i < n; i++) {
		printf("%d\n", arr[i]);
	}

	free(arr);

	return 0;
}