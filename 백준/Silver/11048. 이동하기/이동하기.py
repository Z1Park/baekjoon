import sys
input = sys.stdin.readline
n, m = map(int, input().split())
rooms = [list(map(int, input().split())) for _ in range(n)]
dp = [[0 for _ in range(m)] for _ in range(n)]
dp[0][0] = rooms[0][0]
for i in range(1, m):
    dp[0][i] = dp[0][i-1] + rooms[0][i]
for i in range(1, n):
    dp[i][0] = dp[i-1][0] + rooms[i][0]
for i in range(1, n):
    for j in range(1, m):
        dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + rooms[i][j]
print(dp[-1][-1])