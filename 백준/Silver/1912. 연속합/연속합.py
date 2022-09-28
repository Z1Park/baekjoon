n = int(input())
lst = list(map(int, input().split()))
dp = [lst[0]]
for i in range(1, n):
    dp.append(max(dp[i-1]+lst[i], lst[i]))
print(max(dp))