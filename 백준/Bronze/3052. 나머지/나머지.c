#include <stdio.h>
#include <stdlib.h>

int main() {
	int nums[10];
	int temp=0;

	for (int i = 0; i < 10; i++) {
		scanf("%d",&nums[i]);
		nums[i] = nums[i] % 42;
	}
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < i; j++) {
			if (nums[i] == nums[j])
				nums[i] = -1;
		}
	}

	for (int i = 0; i < 10; i++) {
		if (nums[i] != -1)
			temp += 1;
	}

	printf("%d", temp);

	return 0;
}