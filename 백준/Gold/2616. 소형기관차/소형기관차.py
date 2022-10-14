import sys
input = sys.stdin.readline
n = int(input())
train = [0] + list(map(int, input().split()))
m = int(input())

ps = [0 for _ in range(n+1)]
for i in range(1, n+1):
    ps[i] = ps[i-1] + train[i]

dp = [[0 for _ in range(n+1)] for _ in range(3)]
for i in range(3):
    for j in range((i+1)*m, n+1):
        if i == 0:
            dp[i][j] = max(dp[i][j-1], ps[j]-ps[j-m])
        else:
            dp[i][j] = max(dp[i][j-1], dp[i-1][j-m]+ps[j]-ps[j-m])
print(dp[-1][-1])