n = int(input())
dp = [0, 1]
for i in range(2, n+1):
    m = 100000
    for j in range(1, i):
        if j**2 > i:
            break
        if m > dp[i - j**2]:
            m = dp[i - j**2]
    dp.append(m + 1)
print(dp[n])