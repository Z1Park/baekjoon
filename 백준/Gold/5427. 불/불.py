from collections import deque

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

def bfs():
    count = 0
    for i in range(h):
        for j in range(w):
            if arr[i][j] == '@':
                arr[i][j] = 1
                que.append((i, j, arr[i][j]))
            elif arr[i][j] == '*':
                arr[i][j] = -1
                fire.append((i, j, 0))
            elif arr[i][j] == '#':
                arr[i][j] = -2
            else:
                arr[i][j] = 0
    while que:
        count += 1
        while fire and fire[0][2] < count:
            r, c, time = fire.popleft()
            for i in range(4):
                nr = r+dr[i]
                nc = c+dc[i]
                if 0 <= nr < h and 0 <= nc < w and arr[nr][nc] >= 0:
                    arr[nr][nc] = -1
                    fire.append((nr, nc, time+1))
        while que and que[0][2] <= count:
            r, c, p = que.popleft()
            for i in range(4):
                nr = r+dr[i]
                nc = c+dc[i]
                if 0 <= nr < h and 0 <= nc < w:
                    if arr[nr][nc] == 0:
                        arr[nr][nc] = p + 1
                        que.append((nr, nc, p + 1))
                else:
                    return count
    return "IMPOSSIBLE"

tc = int(input())
for t in range(tc):
    flag = True
    w, h = map(int, input().split())
    arr = [list(input()) for _ in range(h)]
    que = deque()
    fire = deque()
    print(bfs())