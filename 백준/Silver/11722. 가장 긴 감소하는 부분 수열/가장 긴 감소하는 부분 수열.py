n = int(input())
lst = list(map(int, input().split()))
dp = [1]
for i in range(1, n):
    tmp = 0
    for j in range(i):
        if lst[j] > lst[i] and tmp < dp[j]:
            tmp = dp[j]
    dp.append(tmp+1)
print(max(dp))