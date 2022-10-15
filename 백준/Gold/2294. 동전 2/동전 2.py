n, k = map(int, input().split())
coins = [int(input()) for _ in range(n)]
dp = [10001 for _ in range(k+1)]
dp[0] = 0
for c in coins:
    for i in range(c, k+1):
        dp[i] = min(dp[i], dp[i-c]+1)
print(-1 if dp[-1] == 10001 else dp[-1])