n = int(input())
price = [0] + list(map(int, input().split()))
dp = [0 for _ in range(n+1)]
dp[0] = 0
dp[1] = price[1]
for i in range(2, n+1):
    m = 0
    for j in range(1, i):
        if m < dp[j] + price[i-j]:
            m = dp[j] + price[i-j]
    dp[i] = max(m, price[i])
print(dp[-1])