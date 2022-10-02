from collections import deque
n = int(input())
arr = [list(input()) for _ in range(n)]
visit = [[0 for a in range(n)] for b in range(n)]
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]
que = deque()
cnt1 = 0
while True:
    idx = 0
    while idx < n**2:
        if visit[idx//n][idx%n] == 0:
            visit[idx//n][idx%n] = 1
            cnt1 += 1
            que.append((idx//n, idx%n, arr[idx//n][idx%n]))
            break
        idx += 1
    if idx == n**2:
        break
    while que:
        r, c, color = que.popleft()
        for i in range(4):
            nr = r+dr[i]
            nc = c+dc[i]
            if 0 <= nr < n and 0 <= nc < n and arr[nr][nc] == color and visit[nr][nc] == 0:
                visit[nr][nc] = 1
                que.append((nr, nc, color))
for i in range(n):
    for j in range(n):
        if arr[i][j] == 'R':
            arr[i][j] = 'G'
cnt2 = 0
while True:
    idx = 0
    while idx < n**2:
        if visit[idx//n][idx%n] == 1:
            visit[idx//n][idx%n] = 2
            cnt2 += 1
            que.append((idx//n, idx%n, arr[idx//n][idx%n]))
            break
        idx += 1
    if idx == n**2:
        break
    while que:
        r, c, color = que.popleft()
        for i in range(4):
            nr = r+dr[i]
            nc = c+dc[i]
            if 0 <= nr < n and 0 <= nc < n and arr[nr][nc] == color and visit[nr][nc] == 1:
                visit[nr][nc] = 2
                que.append((nr, nc, color))
print(cnt1, cnt2)