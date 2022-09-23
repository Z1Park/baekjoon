from collections import deque

dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

n, m, h = map(int, input().split())
lst = []
for i in range(h):
    lst.append([list(map(int, input().split())) for _ in range(m)])

que = deque()
for k in range(h):
    for j in range(m):
        for i in range(n):
            if lst[k][j][i] == 1:
                que.append((i, j, k, 0))

while que:
    x, y, z, t = que.popleft()
    for i in range(6):
        if 0 <= x+dx[i] < n and 0 <= y+dy[i] < m  and\
            0 <= z+dz[i] < h and lst[z+dz[i]][y+dy[i]][x+dx[i]] == 0:
            lst[z+dz[i]][y+dy[i]][x+dx[i]] = 1
            que.append((x+dx[i], y+dy[i], z+dz[i], t + 1))

for k in range(h):
    for j in range(m):
        if 0 in lst[k][j]:
            t = -1
            break
    if t == -1:
        break
print(t)