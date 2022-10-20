n = int(input())
dp = [0, 0, 1]
for i in range(3, n+1):
    dp.append(dp[i-2]*2 + dp[i-1])
print(dp[n] % 1000000007)