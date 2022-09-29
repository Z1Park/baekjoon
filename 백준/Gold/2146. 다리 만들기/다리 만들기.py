from collections import deque

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]
que = deque()
island_num = 2
while True:
    flag = True
    for i in range(n):
        if 1 in arr[i]:
            flag = False
            for j in range(n):
                if arr[i][j] == 1:
                    arr[i][j] = island_num
                    que.append((i, j, island_num))
                    island_num += 1
                    break
            break
    if flag:
        break
    while que:
        r, c, is_num = que.popleft()
        for i in range(4):
            nr = r+dr[i]
            nc = c+dc[i]
            if 0 <= nr < n and 0 <= nc < n and arr[nr][nc] == 1:
                arr[nr][nc] = is_num
                que.append((nr, nc, is_num))

land = 2
m = 10000
while land < island_num - 1:
    for i in range(n):
        for j in range(n):
            if arr[i][j] == land:
                for k in range(4):
                    nr = i+dr[k]
                    nc = j+dc[k]
                    if 0 <= nr < n and 0 <= nc < n and arr[nr][nc] == 0 and (nr, nc, 0, arr[i][j]) not in que:
                        que.append((nr, nc, 0, arr[i][j]))
    while que:
        r, c, cnt, is_num = que.popleft()
        if arr[r][c] > 1 and arr[r][c] != is_num:
            if m > cnt:
                m = cnt
            continue
        elif m < cnt:
            continue
        arr[r][c] = 1
        for i in range(4):
            nr = r+dr[i]
            nc = c+dc[i]
            if 0 <= nr < n and 0 <= nc < n and arr[nr][nc] != 1 and arr[nr][nc] != land and (nr, nc, cnt+1, is_num) not in que:
                que.append((nr, nc, cnt+1, is_num))
    land += 1
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 1:
                arr[i][j] = 0
print(m)