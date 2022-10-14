import sys
from collections import deque
input = sys.stdin.readline
n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]
que = deque()
time = 0
while True:
    flag = True
    arr[0][0] = time-1
    que.append([0, 0])
    while que:
        r, c = que.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < n and 0 <= nc < m:
                if arr[nr][nc] == time or arr[nr][nc] == 0:
                    arr[nr][nc] = time-1
                    que.append([nr, nc])
                elif arr[nr][nc] >= 1:
                    arr[nr][nc] += 1
    for i in range(n):
        for j in range(m):
            if arr[i][j] >= 3:
                arr[i][j] = time-1
                flag = False
            elif arr[i][j] == 2:
                arr[i][j] = 1
    if flag:
        break
    time -= 1
print(-time)