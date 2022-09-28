n = int(input())
wine = [int(input()) for _ in range(n)]
dp = [wine[0]]
if n >= 2:
    dp.append(wine[0]+wine[1])
if n >= 3:
    dp.append(max(wine[0]+wine[1], wine[0]+wine[2], wine[1]+wine[2]))
for i in range(3, n):
    dp.append(max(dp[i-1], dp[i-2]+wine[i], dp[i-3]+wine[i-1]+wine[i]))
print(dp[n-1])