import sys
input = sys.stdin.readline
n, m = map(int, input().split())
arr = [list(map(int, input().rstrip())) for _ in range(n)]

dp = [[0 for _ in range(m)] for _ in range(n)]
dp[n-1][m-1] = arr[n-1][m-1]
max_val = arr[n-1][m-1]
for i in range(n-1, -1, -1):
    for j in range(m-1, -1, -1):
        if i == n-1 and j == m-1:
            continue
        if i == n-1 or j == m-1:
            dp[i][j] = arr[i][j]
        else:
            if arr[i][j] == 1:
                dp[i][j] = min(dp[i+1][j], dp[i][j+1], dp[i+1][j+1])+1
            else:
                dp[i][j] = 0
            if dp[i][j] > max_val:
                max_val = dp[i][j]
print(max_val**2)