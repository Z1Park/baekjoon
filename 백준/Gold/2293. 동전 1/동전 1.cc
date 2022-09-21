#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n, k;
    int i, j;
    int dp[10001] = {0,};
    int coins[100];
    
    scanf("%d %d", &n, &k);
    
    for (i=0;i<n;i++)
    {
        scanf("%d", &coins[i]);
    }
    
    dp[0] = 1;
    for (i=0; i<n; i++)
    {
        for (j = coins[i]; j<=k; j++)
        {
            dp[j] += dp[j-coins[i]];
        }
    }
    
    printf("%d", dp[k]);
    
    return 0;
}