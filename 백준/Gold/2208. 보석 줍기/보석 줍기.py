n, m = map(int, input().split())
jew = [0] + [int(input()) for _ in range(n)]
vsum = [0 for _ in range(n+1)]
dp = [[0, 0] for _ in range(n+1)]
for i in range(1, n+1):
    vsum[i] = vsum[i-1] + jew[i]
dp[m][1] = vsum[m]
for i in range(m+1, n+1):
    dp[i][0] = max(dp[i-1][0], dp[i-1][1])
    dp[i][1] = max(vsum[i]-vsum[i-m], dp[i-1][1]+jew[i])
print(max(dp[-1]))