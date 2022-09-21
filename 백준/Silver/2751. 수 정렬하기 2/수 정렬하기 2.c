#include <stdio.h>
#include <stdlib.h>

int nums[1000000] = {0};

int compare(const void *a, const void *b)
{
    if (*(int *)a > *(int *)b)
        return 1;
    else if (*(int *)a < *(int *)b)
        return -1;
    else
        return 0;
}

int main()
{
    int n;

    scanf("%d", &n);
    for (int i = 0; i < n; i++)
        scanf("%d", &nums[i]);
    qsort(nums, n, sizeof(int), compare);
    for (int i = 0; i < n; i++)
        printf("%d\n", nums[i]);
    return 0;
}