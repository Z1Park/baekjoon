import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

shark = []
for i in range(n):
    for j in range(n):
        if arr[i][j] == 9:
            arr[i][j] = 0
            shark = [i, j]
            break
    if shark:
        break
dr = [-1, 0, 0, 1]
dc = [0, -1, 1, 0]
size = 2
eat = 0
dis = 0
while True:
    visit = [[False for _ in range(n)] for _ in range(n)]
    flag = True
    que = deque()
    que.append([shark[0], shark[1], 0])
    visit[shark[0]][shark[1]] = True
    dist_lst = []
    while que:
        r, c, cnt = que.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < n and 0 <= nc < n and not visit[nr][nc]:
                if arr[nr][nc] == 0 or arr[nr][nc] == size:
                    visit[nr][nc] = True
                    que.append([nr, nc, cnt+1])
                elif arr[nr][nc] < size:
                    flag = False
                    dist_lst.append([cnt+1, nr, nc])
    if flag:
        break
    dist_lst.sort()
    shark = [dist_lst[0][1], dist_lst[0][2]]
    dis += dist_lst[0][0]
    arr[shark[0]][shark[1]] = 0
    eat += 1
    if eat >= size and size <= 6:
        eat = 0
        size += 1
print(dis)