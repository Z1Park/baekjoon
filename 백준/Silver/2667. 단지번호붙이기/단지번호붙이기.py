from collections import deque

n = int(input())
arr = [list(map(int, input())) for _ in range(n)]
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
result = []
while land < island_num:
    s = 0
    for i in range(n):
        for j in range(n):
            if arr[i][j] == land:
                s += 1
    result.append(s)
    land += 1
result.sort()
print(len(result))
for i in result:
    print(i)