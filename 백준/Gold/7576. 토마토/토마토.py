from collections import deque

dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]

n, m = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(m)]

que = deque()
for j in range(m):
    for i in range(n):
        if lst[j][i] == 1:
            que.append((i, j, 0))

while que:
    x, y, t = que.popleft()
    for i in range(6):
        if 0 <= x+dx[i] < n and 0 <= y+dy[i] < m  and lst[y+dy[i]][x+dx[i]] == 0:
            lst[y+dy[i]][x+dx[i]] = 1
            que.append((x+dx[i], y+dy[i], t + 1))

for j in range(m):
    if 0 in lst[j]:
        t = -1
        break
print(t)