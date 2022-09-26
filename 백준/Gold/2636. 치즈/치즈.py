from collections import deque

row, col = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(row)]
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

def check_edge(r, c):
    global lst
    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]
        if lst[nr][nc] == 0:
            return True
    return False

ss = 0
count = 0
que = deque()
while True:
    tmp = 0
    que.append((0, 0))
    while que:
        r, c = que.popleft()
        for i in range(4):
            nr = r+dr[i]
            nc = c+dc[i]
            if 0 <= nr < row and 0 <= nc < col:
                if lst[nr][nc] == 0 and (nr, nc) not in que:
                    lst[nr][nc] = -1
                    que.append((nr, nc))
                elif lst[nr][nc] == 1:
                    tmp += 1
                    lst[nr][nc] = 2
    for i in range(row):
        for j in range(col):
            if lst[i][j] == -1 or lst[i][j] == 2:
                lst[i][j] = 0
    if tmp == 0:
        break
    else:
        count += 1
        ss = tmp
print(count)
print(ss)