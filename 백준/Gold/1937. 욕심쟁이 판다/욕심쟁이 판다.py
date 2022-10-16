import sys
sys.setrecursionlimit(250000)
input = sys.stdin.readline
n = int(input())
forest = [list(map(int, input().split())) for _ in range(n)]
dp = [[0 for _ in range(n)] for _ in range(n)]
visit = [[False for _ in range(n)] for _ in range(n)]
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

def dfs(r, c):
    global max_value
    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]
        if 0 <= nr < n and 0 <= nc < n and forest[r][c] < forest[nr][nc]:
            if not visit[nr][nc]:
                visit[nr][nc] = True
                dp[r][c] = max(dp[r][c], dfs(nr, nc)+1)
            else:
                dp[r][c] = max(dp[r][c], dp[nr][nc]+1)
            if dp[r][c] > max_value:
                max_value = dp[r][c]
    return dp[r][c]

max_value = 0
for i in range(n):
    for j in range(n):
        if not visit[i][j]:
            visit[i][j] = True
            dfs(i, j)
print(max_value+1)