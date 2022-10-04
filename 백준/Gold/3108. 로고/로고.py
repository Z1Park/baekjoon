from collections import deque

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

arr = [[0 for _ in range(2001)] for _ in range(2001)]
points = []
n = int(input())
for i in range(n):
    x1, y1, x2, y2 = map(int, input().split())
    x1 = (x1+500)*2
    y1 = (y1+500)*2
    x2 = (x2+500)*2
    y2 = (y2+500)*2
    points.append([x1, y1])
    for j in range(x1, x2+1):
        if j == x1 or j == x2:
            for k in range(y1, y2+1):
                arr[j][k] = 1
        else:
            arr[j][y1] = 1
            arr[j][y2] = 1

cnt = 0
idx = 0
que = deque()
if arr[1000][1000] == 1:
    que.append((1000, 1000))
while True:
    while que:
        r, c = que.popleft()
        for i in range(4):
            nr = r+dr[i]
            nc = c+dc[i]
            if 0 <= nr < 2001 and 0 <= nc < 2001 and arr[nr][nc] == 1 and (nr, nc) not in que:
                arr[nr][nc] = 2
                que.append((nr, nc))
    flag = True
    while not que:
        if not points:
            flag = False
            break
        tmp_r, tmp_c = points.pop()
        if arr[tmp_r][tmp_c] == 1:
            cnt += 1
            arr[tmp_r][tmp_c] = 2
            que.append((tmp_r, tmp_c))
    if not flag:
        break
print(cnt)