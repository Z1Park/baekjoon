from collections import deque
m, n = map(int, input().split())
arr = [list(map(int, input())) for _ in range(n)]
dp = [[-1 for _ in range(m)] for _ in range(n)]
dp[0][0] = 0
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]
que = deque()
que.append((0, 0))
while que:
    r, c = que.popleft()
    if r == n-1 and c == m-1:
        break
    for i in range(4):
        nr = r+dr[i]
        nc = c+dc[i]
        if 0 <= nr < n and 0 <= nc < m and dp[nr][nc] == -1:
            if arr[nr][nc] == 1:
                dp[nr][nc] = dp[r][c] + 1
                que.append((nr, nc))
            else:
                dp[nr][nc] = dp[r][c]
                que.appendleft((nr, nc))
print(dp[-1][-1])