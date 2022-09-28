n = int(input())
dp = [1, 0, 3] + [0 for _ in range(n-2)]
for i in range(3, n+1):
    if i%2 == 1:
        continue
    for j in range(1, i//2+1):
        if j == 1:
            dp[i] += dp[i-j*2] * 3
        else:
            dp[i] += dp[i-j*2] * 2
print(dp[n])