dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

def dfs(r, c, idx):
    if idx == len(strn):
        return 1
    if visit[r][c][idx] != -1:
        return visit[r][c][idx]
    visit[r][c][idx] = 0
    for i in range(4):
        for j in range(1, k+1):
            nr = r+dr[i]*j
            nc = c+dc[i]*j
            if 0 <= nr < n and 0 <= nc < m and arr[nr][nc] == strn[idx]:
                visit[r][c][idx] += dfs(nr, nc, idx+1)
    return visit[r][c][idx]

n, m, k = map(int, input().split())
arr = [list(input()) for _ in range(n)]
strn = list(input())
visit = [[[-1] * len(strn) for a in range(m)] for b in range(n)]
cnt = 0
for i in range(n):
    for j in range(m):
        if arr[i][j] == strn[0]:
            cnt += dfs(i, j, 1)
print(cnt)