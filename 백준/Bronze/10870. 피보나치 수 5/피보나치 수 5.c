#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int main() {
	int n;
	int arr[20];
	
	scanf("%d", &n);

	arr[0] = 0;
    arr[1] = 1;
    
    for (int i = 2; i <= n; i++)
    {
        arr[i] = arr[i-1] + arr[i-2];
    }

    printf("%d", arr[n]);
    
	return 0;
}